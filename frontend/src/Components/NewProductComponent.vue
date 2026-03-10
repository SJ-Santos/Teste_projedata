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

.form{
    background-color: white;
    padding: 20px;
    border-radius: 8px;
    width: 300px;
    margin: 20px auto;
}
.form h2{
    margin-bottom: 20px;
}
.form input{
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
}
.form .inputs{
    display: flex;
    gap: 10px;
}
.form .inputs input{
    flex: 1;
}
.form .inputs button{
    padding: 10px 20px;
    background-color: #28a745;
    color: white;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

</style>
