package com.boot.security.server.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import net.sf.json.JSONObject;

/**
 * @Description:发送http请求帮助类
 */
public class HttpHelper {

	//region sendPostByHttpUrlConnection String data
	/**
	 * POST请求
	 *
	 * @param urlStr
	 *            请求地址
	 * @param data
	 *            数据内容
	 * @param charset
	 *            编码，最好传“UTF-8”
	 * @return
	 * @exception RuntimeException
	 */
	public static String sendPostByHttpUrlConnection(String urlStr, String data, String charset) {
		StringBuffer resultBuffer = null;
		HttpURLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		// 发送请求
		try {
			URL url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			if (data != null && data.length() > 0) {
				osw = new OutputStreamWriter(con.getOutputStream(), charset);
				osw.write(data);// data.getBytes("UTF-8")
				osw.flush();
			}
			// 读取返回内容
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}
		return resultBuffer.toString();
	}
	//endregion
	
	//region sendPostByHttpUrlConnection Map<String, Object> params
	/**
	 * POST请求
	 *
	 * @param urlStr
	 *            请求地址
	 * @param params
	 *            参数字典
	 * @param charset
	 *            编码，最好传“UTF-8”
	 * @return
	 * @exception RuntimeException
	 */
	public static String sendPostByHttpUrlConnection(String urlStr, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		String sbParams = JoiningTogetherParams(params);
		HttpURLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		// 发送请求
		try {
			URL url = new URL(urlStr);
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setDoOutput(true);
			con.setDoInput(true);
			con.setUseCaches(false);
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			if (sbParams != null && sbParams.length() > 0) {
				osw = new OutputStreamWriter(con.getOutputStream(), charset);
				osw.write(sbParams);
				osw.flush();
			}
			// 读取返回内容
			resultBuffer = new StringBuffer();
			System.out.println(con.getHeaderField("Content-Length"));
			int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				} finally {
					if (con != null) {
						con.disconnect();
						con = null;
					}
				}
			}
		}

		return resultBuffer.toString();
	}
	//endregion

	//region sendGetByHttpUrlConnection
		public static String sendGetByHttpUrlConnection(String urlStr, Map<String, Object> params, String charset) {
			StringBuffer resultBuffer = null;
			// 构建请求参数
			String sbParams = JoiningTogetherParams(params);
			HttpURLConnection con = null;
			BufferedReader br = null;
			try {
				URL url = null;
				if (sbParams != null && sbParams.length() > 0) {
					url = new URL(urlStr + "?" + sbParams);
				} else {
					url = new URL(urlStr);
				}
				con = (HttpURLConnection) url.openConnection();
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
				con.connect();
				resultBuffer = new StringBuffer();
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						br = null;
						throw new RuntimeException(e);
					} finally {
						if (con != null) {
							con.disconnect();
							con = null;
						}
					}
				}
			}
			return resultBuffer.toString();
		}
	
	//region sendPostByUrlConnection
	public static String sendPostByUrlConnection(String urlStr, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		String sbParams = JoiningTogetherParams(params);
		URLConnection con = null;
		OutputStreamWriter osw = null;
		BufferedReader br = null;
		try {
			URL realUrl = new URL(urlStr);
			// 打开和URL之间的连接
			con = realUrl.openConnection();
			// 设置通用的请求属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			con.setDoOutput(true);
			con.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			osw = new OutputStreamWriter(con.getOutputStream(), charset);
			if (sbParams != null && sbParams.length() > 0) {
				// 发送请求参数
				osw.write(sbParams);
				// flush输出流的缓冲
				osw.flush();
			}
			// 定义BufferedReader输入流来读取URL的响应
			resultBuffer = new StringBuffer();
			int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
			if (contentLength > 0) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
				String temp;
				while ((temp = br.readLine()) != null) {
					resultBuffer.append(temp);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}
	//endregion

	
	//endregion
	
	//region sendGetByUrlConnection
	public static String sendGetByUrlConnection(String urlStr, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		// 构建请求参数
		String sbParams = JoiningTogetherParams(params);
		BufferedReader br = null;
		try {
			URL url = null;
			if (sbParams != null && sbParams.length() > 0) {
				url = new URL(urlStr + "?" + sbParams);
			} else {
				url = new URL(urlStr);
			}
			URLConnection con = url.openConnection();
			// 设置请求属性
			con.setRequestProperty("accept", "*/*");
			con.setRequestProperty("connection", "Keep-Alive");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
			con.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立连接
			con.connect();
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(con.getInputStream(), charset));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}
	//endregion

	//region httpClientPost
	public static String httpClientPost(String urlStr, Map<String, String> params, String charset) {
		StringBuffer resultBuffer = null;
		HttpClient client = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(urlStr);
		//httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
		// 构建请求参数
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		Iterator<Entry<String, String>> iterator = params.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, String> elem = iterator.next();
			list.add(new BasicNameValuePair(elem.getKey(), String.valueOf(elem.getValue())));
		}
		BufferedReader br = null;
		try {
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = client.execute(httpPost);
			// 读取服务器响应数据
			resultBuffer = new StringBuffer();
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
			String temp;
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}
	//endregion
	
	//region httpClientGet
	public static String httpClientGet(String urlStr, Map<String, Object> params, String charset) {
		StringBuffer resultBuffer = null;
		HttpClient client = new DefaultHttpClient();
		BufferedReader br = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				try {
					sbParams.append(URLEncoder.encode(String.valueOf(entry.getValue()), charset));
				} catch (UnsupportedEncodingException e) {
					throw new RuntimeException(e);
				}
				sbParams.append("&");
			}
		}
		if (sbParams != null && sbParams.length() > 0) {
			urlStr = urlStr + "?" + sbParams.substring(0, sbParams.length() - 1);
		}
		HttpGet httpGet = new HttpGet(urlStr);
		try {
			HttpResponse response = client.execute(httpGet);
			// 读取服务器响应数据
			br = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
			String temp;
			resultBuffer = new StringBuffer();
			while ((temp = br.readLine()) != null) {
				resultBuffer.append(temp);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					br = null;
					throw new RuntimeException(e);
				}
			}
		}
		return resultBuffer.toString();
	}
	//endregion

	//region sendSocketPost
	public static String sendSocketPost(String urlStr, Map<String, Object> params, String charset) {
		String result = "";
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;
		try {
			URL url = new URL(urlStr);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}
			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			sb.append("POST " + path + " HTTP/1.1\r\n");
			sb.append("Host: " + host + "\r\n");
			sb.append("Connection: Keep-Alive\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
			sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应体数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, charset);
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, charset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;
	}
	//endregion

	//region sendSocketGet
	public static String sendSocketGet(String urlStr, Map<String, Object> params, String charset) {
		String result = "";
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> entry : params.entrySet()) {
				sbParams.append(entry.getKey());
				sbParams.append("=");
				sbParams.append(entry.getValue());
				sbParams.append("&");
			}
		}
		Socket socket = null;
		OutputStreamWriter osw = null;
		InputStream is = null;
		try {
			URL url = new URL(urlStr);
			String host = url.getHost();
			int port = url.getPort();
			if (-1 == port) {
				port = 80;
			}
			String path = url.getPath();
			socket = new Socket(host, port);
			StringBuffer sb = new StringBuffer();
			sb.append("GET " + path + " HTTP/1.1\r\n");
			sb.append("Host: " + host + "\r\n");
			sb.append("Connection: Keep-Alive\r\n");
			sb.append("Content-Type: application/x-www-form-urlencoded; charset=utf-8 \r\n");
			sb.append("Content-Length: ").append(sb.toString().getBytes().length).append("\r\n");
			// 这里一个回车换行，表示消息头写完，不然服务器会继续等待
			sb.append("\r\n");
			if (sbParams != null && sbParams.length() > 0) {
				sb.append(sbParams.substring(0, sbParams.length() - 1));
			}
			osw = new OutputStreamWriter(socket.getOutputStream());
			osw.write(sb.toString());
			osw.flush();
			is = socket.getInputStream();
			String line = null;
			// 服务器响应体数据长度
			int contentLength = 0;
			// 读取http响应头部信息
			do {
				line = readLine(is, 0, charset);
				if (line.startsWith("Content-Length")) {
					// 拿到响应体内容长度
					contentLength = Integer.parseInt(line.split(":")[1].trim());
				}
				// 如果遇到了一个单独的回车换行，则表示请求头结束
			} while (!line.equals("\r\n"));
			// 读取出响应体数据（就是你要的数据）
			result = readLine(is, contentLength, charset);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					osw = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					throw new RuntimeException(e);
				} finally {
					if (socket != null) {
						try {
							socket.close();
						} catch (IOException e) {
							socket = null;
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return result;
	}
	//endregion

	//region readLine
	private static String readLine(InputStream is, int contentLength, String charset) throws IOException {
		List<Byte> lineByte = new ArrayList<Byte>();
		byte tempByte;
		int cumsum = 0;
		if (contentLength != 0) {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
				cumsum++;
			} while (cumsum < contentLength);// cumsum等于contentLength表示已读完
		} else {
			do {
				tempByte = (byte) is.read();
				lineByte.add(Byte.valueOf(tempByte));
			} while (tempByte != 10);// 换行符的ascii码值为10
		}

		byte[] resutlBytes = new byte[lineByte.size()];
		for (int i = 0; i < lineByte.size(); i++) {
			resutlBytes[i] = (lineByte.get(i)).byteValue();
		}
		return new String(resutlBytes, charset);
	}
	//endregion

	//region JoiningTogetherParams
	private static String JoiningTogetherParams(Map<String, Object> params) {
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
			return sbParams.substring(0, sbParams.length() - 1);
		}
		return "";
	}
	//endregion

	//region sendHttp
	//调用趣满满接口用到
	public static JSONObject sendHttp(Map<String,Object> map,String url) throws IOException{
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");
        Gson gson = new Gson();
        String parameter = gson.toJson(map);
        StringEntity se = new StringEntity(parameter);
        se.setContentType("text/json");
        httpPost.setEntity(se);
        CloseableHttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity, "UTF-8");
        if(result.contains("</div>")){
            result = result.substring(result.lastIndexOf("</div>")+6);
        }
        JSONObject json = JSONObject.fromObject(result);
        
        return json;
    }
	//endregion
	
	/**
     * 向指定 URL 发送POST方法的请求
     * 作者：ccw
     * 创建时间：2016-02-01
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            // 获取URLConnection对象对应的输出流 设置编码格式 防止中文乱码
            out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream(),"utf-8"));
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(),"utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    } 
}