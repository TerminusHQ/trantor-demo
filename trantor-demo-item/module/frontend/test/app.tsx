import './global.amd'
import { Provider } from 'mobx-react'
import React from 'react'
import {
  BrowserRouter,
  RouteComponentProps,
  withRouter,
} from 'react-router-dom'
import { triggerViewAction, ViewComponent } from '@terminus/nusi-engine'
import { menus } from '../debug/setting'
import Layout from './layout'

const App = withRouter(
  ({ history }: RouteComponentProps) => {
    return (
      <Layout
        menus={menus}
        onMenuItemClick={({ viewAction, id }) => {
          triggerViewAction({ history, action: viewAction, menuKey: id })
        }}
      >
        <ViewComponent />
      </Layout>
    )
  })

export default () => {
  return (
    <Provider>
      <BrowserRouter>
        <App />
      </BrowserRouter>
    </Provider>
  )
}
