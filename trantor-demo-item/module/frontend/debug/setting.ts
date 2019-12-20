export const host = 'nusi-engine.terminus.io' // 本地的host，需要进行绑定
export const proxyActionApiPrefix = 'https://dev.gateway.captain.terminus.io' // 网关转发代理
export const proxyStoreApi = 'https://meta-store-dev-8345.captain.terminus.io' // store请求转发代理
export const NUSI_ENGINE_API_PREFIX = '' // 限制请求，api请求前缀，用于搭配controlledMiddleware使用
export const uc = 'https://front-test-8351.captain.terminus.io'
export const menus = [ // 左侧菜单
  {
    name: '用户管理',
    icon: 'user',
    id: '1',
    viewAction: 'user2_User_listAll',
  },
  {
    name: '地址',
    icon: 'address',
    id: '2',
    viewAction: 'user2_Address_listAll',
  }
]
