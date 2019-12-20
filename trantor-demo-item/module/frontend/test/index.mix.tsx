import '../debug/index.mix'
import React from 'react'
import { render } from 'react-dom'
import App from './app'
import { getCurrentUser, getLoginAddr } from './service'

(async () => {
  try {
    await getCurrentUser()
    render(<App />, document.getElementById('app')!)
  } catch (e) {
    if (e.type === 'permission') {
      location.href = getLoginAddr()
    }
  }
})()
