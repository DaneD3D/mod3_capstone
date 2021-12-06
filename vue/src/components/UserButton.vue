<template>
    <div>
        <!--
        <img src="@/assets/1x/UserLogo.png" alt="user-icon">
        -->
        <UserLogo class="userLogo"/>
    </div>
</template>

<script>
import UserLogo from '@/assets/SVG/UserLogo.vue'

export default {
    name: 'user-button',
    components: {
        UserLogo
    }

}
</script>

<style>
.userLogo{
    size: 500%
}

</style>