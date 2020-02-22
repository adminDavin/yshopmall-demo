import request from '@/utils/request'

export function add(data) {
  return request({
    url: 'api/yxSystemGroupData',
    method: 'post',
    data
  })
}

export function del(id) {
  return request({
    url: 'api/yxSystemGroupData/' + id,
    method: 'delete'
  })
}

export function edit(data) {
  return request({
    url: 'api/yxSystemGroupData',
    method: 'put',
    data
  })
}
