import React from 'react';
import {StyleSheet, View, Text, Image} from 'react-native';
class First extends React.Component{
    constructor(props){
        super(props)
        this.state={
            name:'张三'
        }
    }
    render(){
        return(
            <View >
                <Text>初始化项目111111</Text>
            </View>
        );
    }
}
const styles = StyleSheet.create({ //样式表
});
module .exports= First