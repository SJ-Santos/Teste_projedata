
<template>
    <div class="card">
        <div class = "card-header">
            
            <h2>{{product.name}}</h2>
            <button id="arrowbutton" @click="toggleDetails"></button>
            <button id="editbutton" @click="$emit('edit',product)"></button>
            <button id="removebutton" @click="$emit('remove',product)"></button>

        </div>
        
        <div v-if="isOpen" class="card-details">
            <p>Price: {{product.price}}</p>
            <p>Code: {{ product.code }}</p>
            <ul>
                <li v-for="insume in product.inputs":key="insume">
                    {{ insume }}
                </li>

            </ul>
        </div>

    </div>
</template>

<script setup>
import { ref } from 'vue'
//na linha 17 talvez seja necessario alteração depois or causa do formato da lista de insumos
const props = defineProps({
    product:Object
})

const emit = defineEmits(['remove','edit'])

const isOpen = ref(false)

function toggleDetails(){
    isOpen.value = !isOpen.value
}

</script>

<style scoped>

.card{
    border: 1px solid black;
    border-radius: 8px;
    margin: 10px;
    padding: 10px;
}
.card-header{
    display: flex;
    justify-content: space-between;
    align-items: center;
}
#arrowbutton{
    width: 20px;
    height: 20px;
    background-color: transparent;
    border: none;
    background-image: url('../assets/arrow.png');
    background-size: cover;
    cursor: pointer;
    transition: trasform 0.3s ease;
}
#editbutton{ 
    width: 20px;
    height: 20px;
    background-color: transparent;
    border: none;
    background-image: url('../assets/edit.png');
    background-size: cover;
    cursor: pointer;
}
#removebutton{
    width: 20px;
    height: 20px;
    background-color: transparent;
    border: none;
    background-image: url('../assets/remove.png');
    background-size: cover;
    cursor: pointer;
}
</style>
