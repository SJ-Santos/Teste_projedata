<template>

<div class="form">

   <h2>New Insume</h2>

    <input v-model="name" placeholder="Name">
    <input v-model="quantity" placeholder="Quantity">
    
    <button @click="submit">Submit</button>

</div>

</template>
<script setup>

import { ref } from 'vue';

const emit = defineEmits(['create'])

const name = ref("")
const quantity = ref("")

function submit(){
    const newInsume = {
        code:Math.random().toString(36).substr(2, 9),
        name:name.value,
        quantity:quantity.value
    }
    emit('create', newInsume)
    name.value = ""
    quantity.value = ""
}

</script>
<style scoped>

.form{
    background-color: white;
    padding: 20px;
}


</style>
