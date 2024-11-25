package me.aias.sd;

import ai.djl.Device;
import ai.djl.ModelException;
import ai.djl.modality.cv.Image;
import ai.djl.opencv.OpenCVImageFactory;
import ai.djl.translate.TranslateException;
import me.aias.sd.controlnet.LineArtAnimeDetector;
import me.aias.sd.pipelines.StableDiffusionControlNetPipeline;
import me.aias.sd.utils.ImageUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class ControlNetLineArtAnimeCpu {

    private ControlNetLineArtAnimeCpu() {}

    public static void main(String[] args) throws ModelException, IOException, TranslateException {

        Path imageFile = Paths.get("src/test/resources/lineart.png");
        Image image = OpenCVImageFactory.getInstance().fromFile(imageFile);
        String prompt = "A warrior girl in the jungle";

        try (StableDiffusionControlNetPipeline model = new StableDiffusionControlNetPipeline("models/pytorch_cpu/", "controlnet_lineart_anime.pt", Device.cpu());
             LineArtAnimeDetector detector = new LineArtAnimeDetector(512, 512, Device.cpu())) {
            Image img = detector.predict(image);
            Image result = model.generateImage(img, prompt, "", 25);
            ImageUtils.saveImage(result, "ctrlnet_lineart_anime_cpu.png", "output");
        }

    }
}