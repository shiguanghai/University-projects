import React from 'react';
import {StyleSheet, View, Text,Image} from 'react-native';
const Module: () => React$Node = () => {
    return (
      <View style={styles.itemStyle}>
        <Text>扫一扫</Text>
        <Image source={require('./src/assets/arrow.png')}
          style={{
            width:24,
            height:24
          }}/>
      </View>
    );
};
const styles = StyleSheet.create({ //样式表
    itemStyle:{
      height: 40,
      backgroundColor:'#FFF',
      flexDirection:'row',
      justifyContent:'space-between',
      alignItems:'center',
      paddingLeft:5,
      borderBottomWidth:1,
      borderBottomColor:'#ddd'
    }
});
export default Module;