declare module 'requirejs/require.js' {
  export const requirejs: any;
  export const require: any;
  export const define: any;
}

declare module '*.scss' {
  const content: any
  export = content
}

declare module 'superagent-use' {
  import superagent from 'superagent'
  type agentType = typeof superagent
  function wrapper(agent: agentType): agentType & { use(req: any): any }
  export = wrapper
}


declare module 'superagent-prefix' {
  function wrapper(prefix: string): () => string
  export = wrapper
}

declare module 'superagent-mocker' {
  import superagent from 'superagent'
  type agentType = typeof superagent
  function wrapper(agent: agentType): agentType & { use(req: any): any }
  export = wrapper
}

