import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View
} from 'react-native';
import { WebView } from 'react-native-webview'

export default class NewsDetail extends Component {
  constructor(props) {
    super(props);
    this.state = {
      detailHtml: '',
      url: ''
    }
  }
  static navigationOptions = ((props) => {
    return {
      title: props.navigation.state.params.title
    }
  });
  componentDidMount() {
    this.getNewsDetail()
  }

  render() {
    return (
      <WebView
        automaticallyAdjustContentInsets={true}
        source={{ html: this.state.detailHtml, baseUrl: this.state.url }}     //网页数据源
        javaScriptEnabled={true} // 布尔值，控制是否启用 JavaScript。仅在安卓下使用，因为 IOS 默认为启用 JavaScript。默认值为true。
        domStorageEnabled={true} // 仅限 Android 平台。指定是否开启 DOM 本地存储
        // startInLoadingState={true}
      />
    )
  }

  getNewsDetail() {
    let newsId = this.props.navigation.state.params.id;       //获取新闻id
    // console.log(this.props.navigation.state.params.id)
    let url = 'http://c.3g.163.com/nc/article/' + newsId + '/full.html';    //拼接新闻详情的url
    // let url='https://c.m.163.com/news/a/' + newsId + '.html';    //拼接新闻详情的url
    console.log(url)
    fetch(url).then(response => response.json())
      .then((responseJson) => {
        let detail = responseJson[newsId];
        let imgArr = detail.img;                      //抽取数据中的图片数组
        let rawHtml = detail.body;                    //抽取数据中的htmlbody内容
        // console.log(imgArr)
        imgArr.forEach((imgItem) => {                 //遍历图片数组将图片插入到body中
          let imgHtml = '<img src="' + imgItem.src + '" width="100%">';
          rawHtml = rawHtml.replace(imgItem.ref, imgHtml);
        });
        // console.log(imgArr)
        this.setState({
          detailHtml: rawHtml, //将拼接好的网页body保存到state中
          url: url
        });
      })
      .catch((err) => {
        console.log(err);
      })
  }
}
