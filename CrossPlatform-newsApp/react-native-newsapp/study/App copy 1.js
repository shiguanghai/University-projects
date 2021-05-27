import React from 'react';
import {
  StyleSheet, View, Text,Image
} from 'react-native';
const App: () => React$Node = () => {
  return (
      <>
        <View>
          <View style={styles.container}>

            <Text style={styles.font}>
              <Text selectable={false}>我的学院首页</Text>
            </Text>
          </View>
          {/* <Image source={require('./c10.jpg')}
                 style={styles.image_style}></Image> */}
          <Text style={styles.list_item}>1.音梦寻声 唱响校园</Text>
          <Text style={styles.list_item}>2.校园歌手大赛燃动</Text>
          <Text style={styles.list_item}>3.我院开展读书月活动</Text>
          <Text style={styles.news_title}>今日要闻</Text>
          <Text numberOfLines={4} style={styles.news_content}>
            未来五年，学校要充分完成教育和经济发展、产业发展的融合，成为一个创新创业、
            有企业家精神的学校。希望老师们从现在开始更好地提升自身、更新自我，更好地
            理解社会发展趋势。在这样一个变革的时代，希望老师们要加强对全球经济发展和
            中国经济发展趋势的了解、对技术的了解，加强学校与产业、与社会的融合，思考
            身为教师的责任和所需要的能力，大胆变革、勇于创新，推动学校不断发展。
            教育不仅仅是一个事业，还是一种良心，是对家长、对学生的一种责任。希望大家
            一起努力，实现教育创造学生价值的初心。
          </Text>
        </View>
      </>
  );
};
const styles = StyleSheet.create({
  image_style:{
    width:500,height: 180
  },
  container: {                     //页面整体美化
    marginTop:45,                //上边距
    alignItems: 'center',             //垂直居中
    backgroundColor: '#F5FCFF',    //背景颜色
  },
  font:{
    fontWeight:'800',
    textAlign:'center',
    fontSize:25,                    //字号
    backgroundColor:'#CD1D1C',     //背景颜色
    color:'#FFF'                    //字体颜色
  },
  list_item:{                      //列表样式
    height:40,                     //高度
    marginLeft:12,                 //左边距
    marginTop:25,                //上边距
    fontSize:16,                  //字号
    color:'#000',                  //字体颜色
    borderBottomWidth:1,         //边框宽度
    justifyContent:'center',
    borderBottomColor:'#B8C4DB'  //边框颜色
  },
  news_title:{                   //新闻标题部分美化
    fontSize:20,
    fontWeight:'bold',            //设置文本的粗细
    color:'#CD1D1C',
    marginLeft:10,
    marginTop:15,
  },
  news_content:{                //新闻内容部分美化
    marginLeft:15,              //左边距
    marginRight:10,
    fontSize:15,
    color:'#000',               //文字颜色
    lineHeight:30              //设置行高
  }
});
export default App;