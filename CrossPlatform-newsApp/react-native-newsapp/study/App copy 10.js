import React from 'react';
import {StyleSheet, View, Text, Image} from 'react-native';
const App: () => React$Node = () => {
  return (
    <View>
      <View style={[styles.topHomeText, styles.conter]}>
        <Text style={styles.font}>首页</Text>
      </View>
      <View style={styles.interval}>
        <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330214611420.png'}}
          style={{width:'100%',height:200}}></Image>
      </View>
      <View style={styles.continue}>
        <View style={[styles.item, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330221630009.png'}}
            style={styles.menuImage}></Image>
          </View>
          <View>
            <Text style={[styles.font, styles.menuFont]}>新品上市</Text>
          </View>
        </View>
        <View style={[styles.item, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330223827908.png'}}
            style={styles.menuImage}></Image>
          </View>
          <View>
            <Text style={[styles.font, styles.menuFont]}>限时抢购</Text>
          </View>
        </View>
        <View style={[styles.item, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330223932098t5E0eu.png'}}
            style={styles.menuImage}></Image>
          </View>
          <View>
            <Text style={[styles.font, styles.menuFont]}>物流查询</Text>
          </View>
        </View>
        <View style={[styles.item, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330224101339.png'}}
            style={styles.menuImage}></Image>
          </View>
          <View>
            <Text style={[styles.font, styles.menuFont]}>免费领券</Text>
          </View>
        </View>
      </View>
      <View style={[styles.interval, styles.intervalBackground]}></View>
      <View>
        <View style={styles.menuTitle}>
          <View style={styles.titleRedBox}><Text></Text></View>
          <View style={styles.menuTitleStyle}>
            <Text style={[styles.font, styles.menuTitleFont]}>热销商品</Text>
          </View>
          <View style={styles.menuTitleMoreStyle}>
            <Text style={[styles.font, styles.menuTitleMoreFont]}>更多> </Text>
          </View>
        </View>
        <View style={[styles.continue, styles.menuContinue]}>
          <View style={[styles.menuItem, styles.conter]}>
            <View>
              <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330231531097.png'}}
              style={styles.menuCommoditiesImage}></Image>
            </View>
            <View>
              <Text style={[styles.priceFont, styles.menuFont]}>￥36.00</Text>
            </View>
          </View>
          <View style={[styles.menuItem, styles.conter]}>
            <View>
              <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235446735.png'}}
              style={styles.menuCommoditiesImage}></Image>
            </View>
            <View>
              <Text style={[styles.priceFont, styles.menuFont]}>￥96.00</Text>
            </View>
          </View>
          <View style={[styles.menuItem, styles.conter]}>
            <View>
              <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235620626.png'}}
              style={styles.menuCommoditiesImage}></Image>
            </View>
            <View>
              <Text style={[styles.priceFont, styles.menuFont]}>￥129.00</Text>
            </View>
          </View>
        </View>
      </View>
      <View style={[styles.interval, styles.intervalBackground, styles.intervalBackgroundLow]}></View>
      <View>
        <View style={styles.menuTitle}>
          <View style={styles.titleRedBox}><Text></Text></View>
          <View style={styles.menuTitleStyle}>
            <Text style={[styles.font, styles.menuTitleFont]}>每日推荐</Text>
          </View>
          <View style={styles.menuTitleMoreStyle}>
            <Text style={[styles.font, styles.menuTitleMoreFont]}>更多> </Text>
          </View>
        </View>
        <View style={[styles.menuContinue, styles.imageContinue]}>
          <Image source={{uri:'https://public.shiguanghai.top/blog_img/1754121051,1886068052.jpg'}}
          style={{width:'100%',height:250}}></Image>
        </View>
      </View>
      <View style={[styles.continue, styles.footer]}>
        <View style={[styles.footerItem, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235735921.png'}}
            style={styles.footerIcon}></Image>
          </View>
          <View>
            <Text style={[styles.font ,styles.menuFont, styles.footerFont, styles.footerHomeFont]}>首页</Text>
          </View>
        </View>
        <View style={[styles.footerItem, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235828051.png'}}
            style={styles.footerIcon}></Image>
          </View>
          <View>
            <Text style={[styles.font ,styles.menuFont, styles.footerFont]}>分类</Text>
          </View>
        </View>
        <View style={[styles.footerItem, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235905677.png'}}
            style={styles.footerIcon}></Image>
          </View>
          <View>
            <Text style={[styles.font ,styles.menuFont, styles.footerFont]}>购物车</Text>
          </View>
        </View>
        <View style={[styles.footerItem, styles.conter]}>
          <View>
            <Image source={{uri:'https://public.shiguanghai.top/blog_img/image-20210330235933720.png'}}
            style={styles.footerIcon}></Image>
          </View>
          <View>
            <Text style={[styles.font ,styles.menuFont, styles.footerFont]}>我的</Text>
          </View>
        </View>
      </View>
    </View>
  );
};
const styles = StyleSheet.create({ //样式表
  topHomeText: {
    marginTop: 45,
  },
  menuImage: {
    width: 60,
    height: 60,
    borderRadius: 19
  },
  menuCommoditiesImage: {
    width: 125,
    height: 90
  },
  footerIcon: {
    width: 35,
    height: 35
  },
  font: {
    color: '#878787',
    fontSize: 22,
    fontWeight: '400'
  },
  menuFont: {
    marginTop: 8,
    fontSize: 14,
    fontWeight: '600'
  },
  menuTitleMoreFont: {
    fontSize: 16
  },
  menuTitleFont: {
    fontSize: 16
  },
  priceFont: {
    color: '#C89494'
  },
  footerFont: {
    fontSize: 12
  },
  footerHomeFont: {
    color: '#8D4C54'
  },
  menuTitleStyle: {
    marginLeft: 5
  },
  menuTitleMoreStyle: {
    marginLeft: 270
  },
  menuTitle: {
    height: 40,
    flexDirection: 'row',
    alignItems: 'center' // 侧轴对齐方式
  },
  titleRedBox: {
    marginLeft: 10,
    width: 5,
    width: 3,
    backgroundColor: '#B22222'
  },
  interval: {
    marginTop: 12
  },
  intervalBackground: {
    backgroundColor: '#EDEDED',
    height: 25
  },
  intervalBackgroundLow: {
    height: 15
  },
  continue: {
    flexDirection: 'row', // 主轴方向
    height: 100
  },
  menuContinue: {
    height: 120,
    marginLeft: 10,
    marginRight:10,
  },
  imageContinue: {
    height: 170
  },
  item: {
    flex: 1,
    height: 110
  },
  menuItem: {
    flex: 1,
    height: 120
  },
  footerItem: {
    flex: 1,
    height: 70
  },
  conter: {
    justifyContent: 'center', // 主轴对齐方式
    alignItems: 'center' // 侧轴对齐方式
  },
  footer: {
    marginBottom: 0,
    height: 100,
    backgroundColor: '#C8C8C8'
  }
});
export default App;