<template>

  <body>
    <header>
        <div class="containerheader">

          <div class="logo">
              <h1 >Image</h1>
          </div>

          <div class="title"> 
            <h1 style="color:#e0e0e0">fictional name</h1>
          </div>

        </div>
    </header>
    <div class="containerbody">
      
        <div id="upperbar">
          
          <div class="productsandinsumes">
              <button id="productsbtn">Products</button>
              <button id="insumesbtn">Insumes</button>
          </div>

          <div class = "buttonsright">
              <button id="suggestionbtn" @click="showSuggestions" >
                <SugestionComponent v-if="currentView === 'suggestions' && isOpen" @close="isOpen = false "/>

                Suggestion
              </button>
              
              
              <button id="newbtn" @click="showCreate">
                <img src="./icons/add_24dp_E3E3E3_FILL0_wght400_GRAD0_opsz24.png" style="width:14px; margin-right: 6px;">
                <CreateComponent v-if="currentView === 'create'" @addProduct="addProduct" @addInsume="addInput" @close="showCreate"/>
                New
              </button>
          </div>

        </div>

        <div class="productslist">

        </div>

    </div>
  </body>


</template>

<script setup>
import { ref } from 'vue'

import CreateComponent from './Components/CreateComponent.vue'
import SugestionComponent from './Components/SugestionComponent.vue'
import ListComponent from './Components/ListComponent.vue'

const products = ref([])
const insumes = ref([])

function addProduct(p){
  products.value.push(p)
}

function addInput(i){
  inputs.value.push(i)
}

const isOpen = ref(true)

const currentView = ref("")

function showProduct(){
  currentView.value = "product"
}
function showInsume(){
  currentView.value = "insume"
}
function showSuggestions(){
  if(isOpen ){
    currentView.value = ""
    isOpen = false
    return
  }
  currentView.value = "suggestions"
  
}



function showCreate(){
 
  currentView.value = "create"
}
</script>

<style >
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
 body{
  background-color: #f5f5f5;

 }
 .containerheader{
  background-color: blue;
  width: 100%;
  height: 15vh;
  display: flex;
  align-items: center;
 }
 .containerbody{
  background-color: white;
  width: 97%;
  height: 87vh;
  margin-left: 15px;
  margin-right: 15px;
  margin-top: 20px;
  border-radius:15px ;
  box-shadow: 5px 5px 20px rgba(0,0,0,0.2);
  align-items: center;
 }
 #upperbar{
  background-color: #e0e0e0;
  height: 11vh;
  display: flex;
  justify-content: space-between;
  margin-bottom: 20px;
  box-shadow: 3px 3px 8px rgba(0,0,0,0.1);
  align-items: center;
  border-radius: 15px 15px 0 0;
 }
 #productsandinsumes{
  display: flex;
  margin-left: 20px;
 }
 #productsbtn, #insumesbtn{
  background-color:#e0e0e0;
  border-radius: 15px;
  font-size: 13px;
  cursor: pointer;
  padding: 10px 20px;
  margin-left: 6px;
 }
 #buttonsright{
  display: flex;
  margin-right: 20px;
 }
 #newbtn{
  background-color: #05fa1a;
  border-radius: 15px;
  font-size: 14px;
  cursor: pointer;
  padding: 10px 20px;
  margin-right: 8px;
  color:#e0e0e0;
  
 }
 #suggestionbtn{
  background-color: #e0e0e0;
  border-radius: 15px;
  font-size: 13px;
  cursor: pointer;
  padding: 10px 20px;
  margin-right: 8px;
 }
</style>
