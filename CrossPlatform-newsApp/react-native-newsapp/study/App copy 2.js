import React from 'react';
import {StyleSheet, View, Text, Image} from 'react-native';
const App: () => React$Node = () => {
  return (
    <View style={styles.continue}>
      <View style={[styles.item, styles.conter]}>
        <View>
          <Text style={styles.font}>酒店</Text>
        </View>
        <View>
          <Image source={require('./src/assets/hotel.png')}></Image>
        </View>
      </View>
      <View style={[styles.item, styles.conter, styles.leftRightBorder]}>
        <View style={[styles.flexForHotel, styles.conter, styles.BottomBorder]}>
          <Text style={styles.font}>海外酒店</Text>
        </View>
        <View style={[styles.flexForHotel, styles.conter]}>
          <Text style={styles.font}>度假酒店</Text>
        </View>
      </View>
      <View style={[styles.item, styles.conter]}>
        <View>
          <Text style={styles.font}>团购</Text>
        </View>
        <View>
          <Image source={require('./src/assets/hotel.png')}></Image>
        </View>
      </View>
    </View>
  );
};
const styles = StyleSheet.create({ //样式表
  leftRightBorder: {
    borderLeftWidth: 1,
    borderRightWidth: 1,
    borderColor: '#FFF'
  },
  BottomBorder: {
    borderBottomWidth: 1,
    borderColor: '#FFF'
  },
  flexForHotel: {flex: 1},
  font: {
    color: '#FFF',
    fontSize: 16,
    fontWeight: '800'
  },
  continue: {
    marginTop: 45, // 上边距
    marginLeft: 5,
    marginRight: 5,
    borderRadius: 10, // 圆角
    padding: 2,
    flexDirection: 'row', // 主轴方向
    backgroundColor: '#FB5064',
    height: 84,
    borderWidth: 1,
    borderColor: 'black'
  },
  item: {
    flex: 1,
    height: 80
  },
  conter: {
    justifyContent: 'center', // 主轴对齐方式
    alignItems: 'center' // 侧轴对齐方式
  }
});
export default App;