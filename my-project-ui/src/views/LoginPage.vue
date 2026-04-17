<template>
  <div class="login-wrapper">
    <el-card class="login-card">
      <h2 slot="header">系统登录</h2>
      <el-form :model="form" label-width="80px">
        <el-form-item label="用户名">
          <el-input v-model="form.username" />
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="form.password" type="password" />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
import axios from 'axios'

export default {
    name:'LoginPage',
  data() {
    return {
      form: {
        username: '',
        password: ''
      }
    }
  },
  methods: {
    login() {
      axios.post('/api/login', this.form).then(res => {
        console.log('后端返回：',res);
              if (res.code === 200) {
          this.$message.success('登录成功')
          localStorage.setItem('token', res.data)
          console.log('准备跳转/home');
          this.$router.push('/home')
        } else {
          this.$message.error(res.data.message)
        }
      }).catch(err=>{
        console.log('请求失败',err);
        
      })
    }
  }
}
</script>

<style scoped>
.login-wrapper {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.login-card {
  width: 420px;
}
</style>