import React from 'react';
import {StyleSheet, View, Text} from 'react-native';
const App: () => React$Node = () => {
  return (
    <>
      <View style={styles.container}>
        <Text style={styles.font}>初始化项目</Text>
        <View style={styles.con}>
          <View style={styles.nowidth}></View>
          <View style={styles.nowidth}></View>
          <View style={styles.nowidth}></View>
        </View>
      </View>
    </>
  );
};
const styles = StyleSheet.create({ //样式表
  container: { // 页面整体美化
    marginTop: 45, // 上边距
    alignItems: 'center', // 侧轴对齐方式
    // justifyContent: 'center', // 主轴对齐方式
    backgroundColor: '#F5FCFF'
  },
  con: {
    flexDirection: 'row', // 主轴方向：row 水平布局/ column 竖直布局
    flexWrap: 'wrap' // wrap 换行/ no-wrap 不换行
  },
  nowidth: {
    height: 30,
    width: 30,
    margin: 2,
    backgroundColor: '#F00'
  },
  font: {
    fontWeight: '800',
    textAlign: 'center',
    fontSize: 30
  }
});
export default App;