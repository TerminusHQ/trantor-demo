import 'requirejs/require'
import * as React from 'react'
import * as ReactDOM from 'react-dom'
import moment from 'moment'
import lodash from 'lodash'
import classnames from 'classnames'
import * as mobx from 'mobx'
import * as mobxReact from 'mobx-react'
import * as Nusi from '@terminus/nusi'
import * as NusiEngine from '@terminus/nusi-engine'

if (window.define) {
  const realDefine = window.define
  realDefine('react', React)
  realDefine('react-dom', ReactDOM)
  realDefine('moment', moment)
  realDefine('lodash', lodash)
  realDefine('classnames', classnames)
  realDefine('mobx', mobx)
  realDefine('mobx-react', mobxReact)
  realDefine('@terminus/nusi', Nusi)
  realDefine('@terminus/nusi-engine', NusiEngine)
}

