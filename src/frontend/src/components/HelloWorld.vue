<template>
  <h1>{{ msg }}</h1>
<ul>
  <li v-for="task in tasks" :key="task.id">
    <h3>{{task.name}}</h3>
  </li>
</ul>
</template>

<script>
import axios from 'axios';
export default {
  name: 'HelloWorld',
  data(){
    return {
      msg: "Todo App",
      tasks: []
    }
  },
  mounted() {
    this.fetchTasks();
  },
  methods:{
    fetchTasks(){
      axios.get("/api/tasks").then(function (response){
        this.tasks = response.data;
      }.bind(this));
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
