<template>
  <div>
    <button @click="getData">请求后端</button>
    <p>{{ msg }}</p>
  </div>
</template>

<script>
import { getHello } from '../api/hello'

export default {
  name: 'HelloWorld',
  data() {
    return {
      msg: ''
    }
  },
  methods: {
    getData() {
      getHello().then(res => {
        this.msg = res.data
      })
    }
  }
}
</script>