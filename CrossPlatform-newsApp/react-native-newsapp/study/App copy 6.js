import React from 'react';
import {StyleSheet, View, Text, Image} from 'react-native';
class App extends React.Component{
    constructor(props){
        super(props)
        this.state={
            name:'张三',
            showText:true
        }
        setInterval(()=>{
            this.setState({showText:!this.state.showText})},1000)
    }
    render(){
        let display = this.state.showText?"页面闪烁" :"页面不闪烁";
        return(
            <View >
                <Text style={{color:'#F00',fontSize:30}}>{display}</Text>
            </View>
        );
    }
}
const styles = StyleSheet.create({ //样式表
});
export default App;