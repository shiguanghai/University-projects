import React from 'react';
import TabNavigator from 'react-native-tab-navigator';
import First from './First'
import {StyleSheet, View, Text, Image} from 'react-native';
class App extends React.Component{
  constructor(props){
      super(props)
      this.state={
        selectTab:'hom'
      }
  }
  render(){
    return(
      <TabNavigator>
        <TabNavigator.Item
          title = { '首页' }
          renderIcon = { () => 
            <Image
              source = {{ uri:'https://public.shiguanghai.top/blog_img/home.png' }}
              style = {{ width:30, height:30 }}
            />
          }
          renderSelectedIcon = { () => 
            <Image 
              source = {{ uri:'https://public.shiguanghai.top/blog_img/homePress.png' }}
              style = {{ width:30, height:30 }}
            />
          }
          badgeText = {3}
          selectedTitleStyle = {{ color:'#F00' }}
          selected = {this.state.selectTab == 'home' }
          onPress = { () => this.setState({selectTab:'home'}) }
        >
        </TabNavigator.Item>
        <TabNavigator.Item
          title = { '分类' }
          renderIcon = { () => 
            <Image
              source = {{ uri:'https://public.shiguanghai.top/blog_img/mine.png' }}
              style = {{ width:30, height:30 }}
            />
          }
          renderSelectedIcon = { () => 
            <Image 
              source = {{ uri:'https://public.shiguanghai.top/blog_img/minePress.png' }}
              style = {{ width:30, height:30 }}
            />
          }
          badgeText = {3}
          selectedTitleStyle = {{ color:'#F00' }}
          selected = {this.state.selectTab == 'sort' }
          onPress = { () => this.setState({selectTab:'sort'}) }
        >
        </TabNavigator.Item>
      </TabNavigator>
    );
  }
}
const styles = StyleSheet.create({ //样式表
});
export default App;