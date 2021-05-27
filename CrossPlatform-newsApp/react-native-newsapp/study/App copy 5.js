import React from 'react';
import {StyleSheet, View, Text,Image} from 'react-native';
import Module from './Module';
const App: () => React$Node = () => {
  return (
    <View >
      {/*顶端标题*/}
      <View style={styles.navOuterView}>
        <Text style={{
          color:'#FFF',
          fontSize:17,
          fontWeight: '900'
        }}>
          更多
        </Text>
        <Image source={require('./src/assets/dot.png')}
          style={{
            width:24,
            height:24,
            position:'absolute',
            right:20,
            bottom:20
          }}/>
      </View>
      {/*下端内容*/}
      <View>
        <View style={styles.itemStyle}>
          <Text>扫一扫</Text>
          <Image source={require('./src/assets/arrow.png')}
            style={{
              width:24,
              height:24
            }}/>
        </View>
      </View>
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
      marginLeft:5,
      borderBottomWidth:1,
      borderBottomColor:'#ddd'
    },
    navOuterView:{
      marginTop:40,
      height: 60,
      backgroundColor:'#36C5B7',
      flexDirection:'row',
      justifyContent:'center',
      alignItems:'center'
    }
});
export default App;