<template>

<div class="suggestion">

    <h2>Product Suggestions</h2>

    <ul>
        <li v-for="product in products" :key="product.code">
            {{ product.name }} - {{ product.price }}
        </li>
    </ul>

    <button id="buttonacceptsuggestion" @click="suggest">Get Suggestions</button>
    <button id="closesuggestion" @click="close">Close</button>
</div>

</template>
<script setup>

import {ref} from 'vue'

const props = defineProps({
    products:Array,
})

const emit = defineEmits(['suggest',"close"])

function close(){
    emit("close")
}

function suggest(){
    emit('suggest')
}

</script>
<style scoped>

.suggestion{
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    width: 400px;
    height: 500px;
    right: 410px;
    margin-bottom: 400px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    position: absolute;

    
}

#buttonacceptsuggestion{
    background-color: #4CAF50;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 20px;
}
#closesuggestion{
    background-color: #f44336;
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 20px;
    margin-left: 10px;
}

</style>
