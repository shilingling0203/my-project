<template>
    <div>
          <!-- <div style="padding:20px">
    <h2>欢迎进入后台管理系统</h2>
    <el-button type="danger" @click="logout">退出登录</el-button>
  </div> -->
  <el-radio-group v-model="isCollapse" style="margin-bottom: 20px;">
    <el-radio-button :label="false">展开</el-radio-button>
    <el-radio-button :label="true">收起</el-radio-button>
  </el-radio-group>
  <el-menu default-active="1-4-1" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">

        <el-menu-item index="1">
         <i class="el-icon-location"></i>
        <span slot="title">控制台</span>
    </el-menu-item>
    <el-menu-item index="2">
        <i class="el-icon-shopping-cart-2"></i>
        <span slot="title">销售管理</span>
    </el-menu-item>
    <el-menu-item index="3">
        <i class="el-icon-box"></i>
        <span slot="title">采购管理</span>
    </el-menu-item>
 <el-menu-item index="4">
        <i class="el-icon-notebook-2"></i>
        <span slot="title">库存管理</span>
    </el-menu-item>
     <el-menu-item index="5">
        <i class="el-icon-coin"></i>
        <span slot="title">财务管理</span>
    </el-menu-item>
     <el-menu-item index="6">
        <i class="el-icon-user"></i>
        <span slot="title">客户关系</span>
    </el-menu-item>
        <el-menu-item index="7">
        <i class="el-icon-date"></i>
        <span slot="title">供应商管理</span>
    </el-menu-item>
           <el-menu-item index="8">
        <i class="el-icon-pie-chart"></i>
        <span slot="title">报表中心</span>
    </el-menu-item>
    
        <el-submenu index="9">
        <template slot="title">
              <i class="el-icon-setting"></i>
         
            <span slot="">系统管理</span>
        </template>
        <el-menu-item-group>
            <span slot="title">菜单配置</span>
            <el-menu-item index="4-1">主菜单</el-menu-item>
            <el-menu-item index="4-2">菜单</el-menu-item>
        </el-menu-item-group>
        <el-menu-item-group title="权限配置">
            <el-menu-item index="4-3">权限</el-menu-item>
        </el-menu-item-group>
        <el-submenu index="4-4">
            <span slot="title">用户管理</span>
            <el-menu-item index="4-4-1">用户信息</el-menu-item>
        </el-submenu>
    </el-submenu>
  </el-menu>
    </div>

</template>

<script>
export default {
    name:"HomePage",
    data(){
        return{
            isCollapse:true
        };

    },
  methods: {
    logout() {
      localStorage.removeItem('token')
      this.$router.push('/login')
    },
    handleOpen(key,keyPath){
        console.log(key,keyPath);
        
    },
    handleClose(key,keyPath){
        console.log(key,keyPath);
        
    }
  }
}
</script>

<style>
.el-menu-vertical-demo:not(.el-menu--collapse){

    width: 200px;
    min-height: 400px;
}

</style>