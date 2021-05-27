import React from 'react'
import {
  StyleSheet,
  View,
  Text,
  Image
} from 'react-native'
import TabNavigator from 'react-native-tab-navigator'

//所依赖的模块组件
import ReadPage from './app/readPage'

class App extends React.Component {

  // 构造器
  constructor (props) {
    super (props)
    this.state = {
      selectTab: 'readTab'
    }
  }

  // 私有方法
  _renderContent (moduleName) {
    let view = <ReadPage/>
    switch (moduleName) {
      case 'readTab':
        view = <ReadPage/>
        break
      default :
        view = <ReadPage/>
        break
    }
    return view
  }

  render () {
    return (
      <TabNavigator style={styles.topHomeText}>

        <TabNavigator.Item
          title={'卫生间'}
          renderIcon={() => <Image source={require('./icons/bathroom.png')}
            style={{ width: 30, height: 30 }}
          />}
          renderSelectedIcon={() => <Image source={require('./icons/bathroom-o.png')}
            style={{ width: 30, height: 30 }}
          />}
          badgeText={3}
          selectedTitleStyle={{ color: '#F00' }}
          selected={this.state.selectTab == 'home'}
          onPress={() => this.setState({ selectTab: 'home' })}
        >
          <View><Text>我是卫生间</Text></View>
        </TabNavigator.Item>


        <TabNavigator.Item
          title={'阅读'}
          renderIcon={() => <Image source={require('./icons/read.png')}
            style={{ width: 30, height: 30 }}
          />}
          renderSelectedIcon={() => <Image source={require('./icons/read-o.png')}
            style={{ width: 30, height: 30 }}
          />}
          badgeText={3}
          selectedTitleStyle={{ color: '#F00' }}
          selected={this.state.selectTab == 'readTab'}
          onPress={() => this.setState({ selectTab: 'readTab' })}
        >
          {this._renderContent('readTab')}
        </TabNavigator.Item>

        <TabNavigator.Item
          title={'天气'}
          renderIcon={() => <Image source={require('./icons/weather.png')}
            style={{ width: 30, height: 30 }}
          />}
          renderSelectedIcon={() => <Image source={require('./icons/weather-o.png')}
            style={{ width: 30, height: 30 }}
          />}
          badgeText={3}
          selectedTitleStyle={{ color: '#F00' }}
          selected={this.state.selectTab == 'shop'}
          onPress={() => this.setState({ selectTab: 'shop' })}
        >
          <View><Text>我是天气</Text></View>
        </TabNavigator.Item>

        <TabNavigator.Item
          title={'设置'}
          renderIcon={() => <Image source={require('./icons/setting.png')}
            style={{ width: 30, height: 30 }}
          />}
          renderSelectedIcon={() => <Image source={require('./icons/setting-o.png')}
            style={{ width: 30, height: 30 }}
          />}
          badgeText={3}
          selectedTitleStyle={{ color: '#F00' }}
          selected={this.state.selectTab == 'more'}
          onPress={() => this.setState({ selectTab: 'more' })}
        >
          <View><Text>我是设置</Text></View>
        </TabNavigator.Item>

      </TabNavigator>
    );
  }
}
const styles = StyleSheet.create({ //样式表
  topHomeText: {
    marginTop: 30
  }
})

export default App;

// module.exports = First