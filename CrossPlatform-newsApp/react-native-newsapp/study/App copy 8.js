import React from 'react';
import { StyleSheet, View, Text, Image, FlatList } from 'react-native';
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      title: '张三',
      year: '2021',
      movies1: [],
      loaded: false
    }
  }
  componentDidMount() {
    //在这个生命周期函数里做请求1.fetch加请求地址2.第一个then是所有数据转成json,3.第2个then把上面的json进行解析 4.catch里捕获异常
    fetch("http://facebook.github.io/react-native/movies.json")
      .then((response) => response.json())
      .then((responseJosn) => {
        this.setState({
          title: responseJosn.movies[0].title,
          year: responseJosn.movies[0].releaseYear,
          movies1: responseJosn.movies
        })
      })
      .catch((error) => console.log(error))
  }
  render() {
    if (this.state.loaded){
      return(
        <View style={{flex:1, backgroundColor:'#F00'}}/>
      )
    }
    return (
      <View  >
        <Text style={styles.styfont}>电影名:{this.state.title}</Text>
        <Text style={styles.styfont}>电影年份:{this.state.year}</Text>
        <FlatList
          data={this.state.movies1}
          renderItem={({ item }) => (
            <View style={{flexDirection:'row', justifyContent:'space-between',
            marginTop:10}}>
              <Text style={{fontSize:15}}>id:{item.id}</Text>
              <Text style={{fontSize:15}}>电影名:{item.title}</Text>
              <Text style={{fontSize:15}}>电影年份:{item.releaseYear}</Text>
            </View>
          )}
          //默认每行都要提供一个不重复的key属性
          keyExtractor={item => item.id}
        >
        </FlatList>
      </View>
    );
  }
}
const styles = StyleSheet.create({ //样式表
  styfont: {
    fontSize: 30,
    color: '#F6D513',
  },
});
export default App;