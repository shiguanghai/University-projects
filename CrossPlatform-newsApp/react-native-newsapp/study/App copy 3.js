import React from 'react';
import {StyleSheet, View, Text,TextInput} from 'react-native';
const App: () => React$Node = () => {
    return (
        <View style={[styles.direction,styles.flex]}>
            <View style={styles.flex}>
                <TextInput
                    style= {styles.padding}
                    defaultValue ={'中国'}
                    placeholder = {'请输入你的国籍'}
                    placeholderTextColor ={'#F00'}
                    //editable={false}
                    secureTextEntry = {false}
                    multiline ={true}
                    keyboardType={'numeric'}
                    onChange = {()=>{alert("文字改变")}}
                />
            </View>
            <View><Text>搜索</Text></View>
        </View>
    );
};
const styles = StyleSheet.create({ //样式表
    direction: {
        flexDirection:'row',
        marginTop:50
    },
    flex: {flex: 1},
    padding: {
      padding: 2,
      borderColor: 'black',
      backgroundColor: '#F00',
      
    },
    
});
export default App;