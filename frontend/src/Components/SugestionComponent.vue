<template>

<div class="suggestion">

    <h2>Product Suggestions</h2>

    <ul>
        <li v-for="product in products" :key="product.code">
            {{ product.name }} - {{ product.price }}
        </li>
    </ul>

    <button @click="$emit('suggest')">Get Suggestions</button>
</div>

</template>
<script setup>

import {ref} from 'vue'

const props = defineProps({
    products:Array,
})

const emit = defineEmits(['suggest'])

</script>
<style scoped>
.suggestion{
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    width: 300px;
    height: 400px;
    margin: 500px;
    z-index: 0;
    position: fixed;
}


</style>
