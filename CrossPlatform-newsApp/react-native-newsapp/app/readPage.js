import React, { Component } from 'react'
import {
  Platform,
  StyleSheet,
  Text,
  View,
} from 'react-native'

import { Navigator } from 'react-native-deprecated-custom-components'
// import ZSMain from './app/main/ZSMain';
import ZSLaunch from './app/main/ZSLaunch'


export default class App extends Component<Props> {
  render() {
    return (
      <Navigator
        initialRoute={{ name: "launch", component: ZSLaunch }}
        configureScene={(route) => Navigator.SceneConfigs.FloatFromRight}
        renderScene={(route, navigator) => {
          let Component = route.component
          return <Component {...route.props} navigator={navigator} />
        }}
      />
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  }
})