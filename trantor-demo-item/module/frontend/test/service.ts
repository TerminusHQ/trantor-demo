import { agent } from '@terminus/nusi-engine'
import { uc } from '../debug/setting'

export const getCurrentUser = async () => {
  return agent.get('/api/trantor/user/current')
}

export const getLoginAddr = () =>
  `${uc}/login?redirectUrl=${encodeURI(location.href)}`
