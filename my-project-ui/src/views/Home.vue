<template>
  <div class="app-wrapper">
    <!-- 左侧菜单 -->
    <div class="sidebar">
      <el-menu
        :default-active="$route.path"
        class="el-menu-vertical-demo"
        :collapse="isCollapse"
        @select="handleSelect"
      >
        <el-menu-item index="/dashboard">
          <i class="el-icon-location"></i>
          <span>控制台</span>
        </el-menu-item>
        
        <el-menu-item index="/sales">
          <i class="el-icon-shopping-cart-2"></i>
          <span>销售管理</span>
        </el-menu-item>
          <el-menu-item index="/purchase">
          <i class="el-icon-box"></i>
          <span slot="title">采购管理</span>
        </el-menu-item>

        <el-submenu index="/system">
          <template slot="title">
            <i class="el-icon-setting"></i>
            <span>系统管理</span>
          </template>
          <el-menu-item index="/system/user">用户管理</el-menu-item>
          <el-menu-item index="/system/role">角色管理</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>

    <!-- 右侧内容 -->
    <div class="main-container">
      <router-view />
    </div>
  </div>
</template>

<script>
export default {
    name:'homePage',
  data() {
    return {
      isCollapse: false
    }
  },
  methods: {
    handleSelect(path) {
      this.$router.push(path)
    }
  }
}
</script>

<style scoped>
.app-wrapper {
  display: flex;
  height: 100vh;
}

.sidebar {
  width: auto;
  background: #fff;
}

.main-container {
  flex: 1;
  padding: 20px;
  overflow-y: auto;
  background: #f5f7fa;
}
</style>