

$(function () {
  $('#container').highcharts({
      chart: {
          type: 'spline'
      },
      title: {
          text: '历史成绩曲线图'
      },
      subtitle: {
          text: '包含用户所有的模拟成绩'
      },
      xAxis: {
          type: 'category',
          categories:scorecategories
      },
      yAxis: {
          title: {
              text: '分数（满分100）'
          },
          min: 0,
          max:100,
          minorGridLineWidth: 0,
          gridLineWidth: 0,
          alternateGridColor: null,
          plotBands: [{ // Light air
              from: 0,
              to: 60,
              color: 'rgba(255, 0, 0, 0.1)',
              label: {
                  text: '不及格',
                  style: {
                      color: '#606060'
                  }
              }
          }, { // Light breeze
              from: 60,
              to: 80,
              color: 'rgba(205, 201, 201, 0.1)',
              label: {
                  text: '及格',
                  style: {
                      color: '#606060'
                  }
              }
          }, { // Gentle breeze
              from: 80,
              to: 90,
              color: 'rgba(0, 139, 139, 0.1)',
              label: {
                  text: '良好',
                  style: {
                      color: '#606060'
                  }
              }
          }, { // Fresh breeze
              from: 90,
              to: 100,
              color: 'rgba(144, 238, 144, 0.1)',
              label: {
                  text: '优秀',
                  style: {
                      color: '#606060'
                  }
              }
          }]
      },
      tooltip: {
          valueSuffix: ' 分'
      },
      plotOptions: {
          spline: {
              lineWidth:6,
              states: {
                  hover: {
                      lineWidth: 5
                  }
              },
              marker: {
                  enabled: true
              }
              
          }
      },
      series: [{
          name: 'admin',
          data: [20,50,24,45,65,87,99,77,67,68]

      }]
      ,
      navigation: {
          menuItemStyle: {
              fontSize: '10px'
          }
      }
  });
});				