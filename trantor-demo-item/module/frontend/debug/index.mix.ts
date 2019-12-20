/**
 * 混合调试
 * 多容器、多组件混合调试
 */
import superagent from 'superagent'
import superagentMocker from 'superagent-mocker'
import { dynamicOuter, IConfig } from '@terminus/nusi-engine/lib/components/common/dynamic-utils'

/**
 * 重置返回的自定义控件
 * 该方法仅限本地编写控件时调试，线上不会被暴露出来
 * 示例: import Demo1Show from '../widgets/demo1/src/show'
 */
// if (dynamicOuter.getComponent) {
//   dynamicOuter.getComponent = (config: IConfig) => {
//     // if (xxx) {
//     //  return Demo1Show
//     // }
//   }
// }


/**
 * 拦截单个接口，返回Mock数据
 */

const mock = superagentMocker(superagent)

// DSL拦截
// mock.get('/api/trantor/meta/view/detail', (request) => {
//   return {
//     body: {}
//   }
// })