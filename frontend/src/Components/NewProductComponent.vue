<template>

<div class = "form">

   <h2>New Product</h2>

    <input v-model="name" placeholder="Name">
    <input v-model="value" placeholder="Value">
    <div class = "inputs">
        <input v-model="inputName" placeholder="Input Name">
        <button @click="addInput">Add Input</button>
    </div>
    <ul>
        <li v-for="(input, index) in inputs" :key="index">{{ input }}</li>
    </ul>
    <button @click="submit">Submit</button>
    

</div>


</template>
<script setup>
import {ref} from 'vue'

const emit = defineEmits(['create'])

const name = ref("")
const value = ref("")
const inputs = ref([])
const inputName = ref("")

function addInput(){
  if(inputName.value){
    inputs.value.push(inputName.value)
    inputName.value = ""
  }
}

function submit(){

    const newProduct = {
        code:Math.random().toString(36).substr(2, 9),
        name:name.value,
        price:value.value,
        inputs:inputs.value
    }
    emit('create', newProduct)
    name.value = ""
    value.value = ""
    inputs.value = []
}


</script>
<style >



</style>
