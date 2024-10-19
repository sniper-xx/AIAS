package me.aias;

import ai.djl.ModelException;
import ai.djl.modality.cv.Image;
import ai.djl.opencv.OpenCVImageFactory;
import ai.djl.translate.TranslateException;
import me.aias.util.FeatureComparison;
import me.aias.util.ImageEncoderModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Feature Comparison - 1:1.
 * 特征比对 - 1:1.
 *
 * @author Calvin
 * @email 179209347@qq.com
 * @website www.aias.top
 **/
public final class FeatureComparisonExample {

    private static final Logger logger = LoggerFactory.getLogger(FeatureComparisonExample.class);

    private FeatureComparisonExample() {
    }

    public static void main(String[] args) throws IOException, ModelException, TranslateException {

        Path imageFile1 = Paths.get("src/test/resources/car1.png");
        Image img1 = OpenCVImageFactory.getInstance().fromFile(imageFile1);
        Path imageFile2 = Paths.get("src/test/resources/car2.png");
        Image img2 = OpenCVImageFactory.getInstance().fromFile(imageFile2);

        ImageEncoderModel imageEncoderModel = new ImageEncoderModel();
        imageEncoderModel.init("models/CLIP-ViT-B-32-IMAGE.pt", 4);

        float[] feature1 = imageEncoderModel.predict(img1);
        float[] feature2 = imageEncoderModel.predict(img2);

        // 欧式距离
        // Euclidean distance
        float dis = FeatureComparison.dis(feature1, feature2);
        logger.info(Float.toString(dis));

        // 余弦相似度
        // Cosine similarity
        float cos = FeatureComparison.cosineSim(feature1, feature2);
        logger.info(Float.toString(cos));
    }

}
