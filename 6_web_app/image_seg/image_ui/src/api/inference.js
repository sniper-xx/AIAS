import request from '@/utils/request'

export function generalSegBigForImageUrl(data) {
  return request({
    url: '/seg/generalSegBigForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function generalSegMidForImageUrl(data) {
  return request({
    url: '/seg/generalSegMidForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function generalSegSmallForImageUrl(data) {
  return request({
    url: '/seg/generalSegSmallForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function humanSegForImageUrl(data) {
  return request({
    url: '/seg/humanSegForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function animeSegForImageUrl(data) {
  return request({
    url: '/seg/animeSegForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function clothSegForImageUrl(data) {
  return request({
    url: '/seg/clothSegForImageUrl',
    method: 'get',
    params: {
      url: data.url
    }
  })
}

export function getLabelData(data) {
  return request({
    url: '/seg/getLabelData',
    method: 'post',
    data
  })
}

export function uploadImage(name, imageFile) {
  return request({
    url: '/seg/uploadImage',
    method: 'post',
    params: {
      name: name,
      imageFile: imageFile
    }
  })
}

export default {
  generalSegBigForImageUrl,
  generalSegMidForImageUrl,
  generalSegSmallForImageUrl,
  humanSegForImageUrl,
  animeSegForImageUrl,
  clothSegForImageUrl,
  uploadImage,
  getLabelData
}

