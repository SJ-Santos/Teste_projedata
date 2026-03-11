<template>

<Teleport to="body">

<div class="overlay">

  <div class="modal-create">

    
    <div class="views">

      <button
        :class="{active:activeView==='product'}"
        @click="setView('product')"
      >
        Product
      </button>

      <button
        :class="{active:activeView==='insume'}"
        @click="setView('insume')"
      >
        Insume
      </button>

      <button class="close" @click="emit('close')" src="../icons/close_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24.png">
        Close
      </button>

    </div>

    

    <NewProductComponent
      v-if="activeView === 'product'"
      @create="emit('addProduct',$event)"
    />

    <NewInsumeComponent
      v-if="activeView === 'insume'"
      @create="emit('addInsume',$event)"
    />

  </div>

</div>

</Teleport>

</template>
<script setup>
import {ref} from 'vue'

import NewInsumeComponent from './NewInsumeComponent.vue'
import NewProductComponent from './NewProductComponent.vue'

const emit = defineEmits(['close','addproduct','addinsume'])

const activeView = ref("product")

function setView(view){
    activeView.value = view
}


  
</script>
<style scoped>

.overlay{
  position:fixed;
  top:0;
  left:0;

  width:100vw;
  height:100vh;

  background:rgba(0,0,0,0.4);

  display:flex;
  justify-content:center;
  align-items:center;

  z-index:9999;
}

.modal{
  background:white;
  padding:20px;
  border-radius:10px;
  width:450px;
}

.tabs{
  display:flex;
  gap:10px;
  margin-bottom:20px;
}

.tabs button{
  padding:8px 15px;
  border:none;
  cursor:pointer;
  background:#eee;
}

.tabs button.active{
  background:#0077ff;
  color:white;
}

.close{
  margin-left:auto;
  background:red;
  color:white;
}
</style>   