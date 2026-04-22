<template>
  <div class="register-container">
    <el-card class="register-box">
      <h2>用户注册</h2>

      <el-form
        :model="form"
        :rules="rules"
        ref="registerForm"
        label-width="80px"
      >
        <el-form-item label="用户名" prop="username">
          <el-input v-model="form.username" />
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input v-model="form.password" type="password" />
        </el-form-item>

        <el-form-item label="确认密码" prop="confirmPassword">
          <el-input v-model="form.confirmPassword" type="password" />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="onSubmit">注册</el-button>
          <el-button @click="$router.push('/login')">
            已有账号？去登录
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  name: 'RegisterView',
  data() {
    // 自定义校验：确认密码
    const validateConfirmPassword = (rule, value, callback) => {
      if (value !== this.form.password) {
        callback(new Error('两次输入的密码不一致'))
      } else {
        callback()
      }
    }

    return {
      form: {
        username: '',
        password: '',
        confirmPassword: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, message: '密码至少 6 位', trigger: 'blur' }
        ],
        confirmPassword: [
          { required: true, message: '请确认密码', trigger: 'blur' },
          { validator: validateConfirmPassword, trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    onSubmit() {
      this.$refs.registerForm.validate(async valid => {
        if (!valid) {
            this.$message.error('请填写完整表单')
            return
        }
        console.log('准备发请求');
        console.log(this.form);
        
        // 直接用AXios，排除封装问题
        axios.post('/api/auth/register',{
            username:this.form.username,
            password:this.form.password,
            confirmPassword:this.form.confirmPassword
        }).then(res=>{
            console.log('接口返回',res.data);
            this.$message.success('注册成功');
            this.$router.replace('/login');
            
        }).catch(err=>{
            console.log(err);
            this.$message.error('注册失败')
            
        })
      })
    }
  }
}
</script>