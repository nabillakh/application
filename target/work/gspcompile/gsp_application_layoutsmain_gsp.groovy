import org.codehaus.groovy.grails.plugins.metadata.GrailsPlugin
import org.codehaus.groovy.grails.web.pages.GroovyPage
import org.codehaus.groovy.grails.web.taglib.*
import org.codehaus.groovy.grails.web.taglib.exceptions.GrailsTagException
import org.springframework.web.util.*
import grails.util.GrailsUtil

class gsp_application_layoutsmain_gsp extends GroovyPage {
public String getGroovyPageFileName() { "/WEB-INF/grails-app/views/layouts/main.gsp" }
public Object run() {
Writer out = getOut()
Writer expressionOut = getExpressionOut()
registerSitemeshPreprocessMode()
printHtmlPart(0)
createTagBody(1, {->
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',5,['gsp_sm_xmlClosingForEmptyTag':(""),'charset':("utf-8")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',6,['gsp_sm_xmlClosingForEmptyTag':("/"),'http-equiv':("X-UA-Compatible"),'content':("IE=edge")],-1)
printHtmlPart(1)
createTagBody(2, {->
createTagBody(3, {->
invokeTag('layoutTitle','g',7,['default':("SysProd")],-1)
})
invokeTag('captureTitle','sitemesh',7,[:],3)
})
invokeTag('wrapTitleTag','sitemesh',7,[:],2)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',8,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("description"),'content':("")],-1)
printHtmlPart(1)
invokeTag('captureMeta','sitemesh',9,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("author"),'content':("")],-1)
printHtmlPart(2)
invokeTag('captureMeta','sitemesh',12,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("HandheldFriendly"),'content':("True")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',13,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("MobileOptimized"),'content':("320")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',14,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("viewport"),'content':("width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no")],-1)
printHtmlPart(4)
expressionOut.print(request.contextPath)
printHtmlPart(5)
expressionOut.print(request.contextPath)
printHtmlPart(6)
expressionOut.print(request.contextPath)
printHtmlPart(7)
expressionOut.print(request.contextPath)
printHtmlPart(8)
expressionOut.print(request.contextPath)
printHtmlPart(9)
expressionOut.print(request.contextPath)
printHtmlPart(10)
expressionOut.print(request.contextPath)
printHtmlPart(11)
expressionOut.print(request.contextPath)
printHtmlPart(12)
expressionOut.print(request.contextPath)
printHtmlPart(13)
expressionOut.print(request.contextPath)
printHtmlPart(14)
expressionOut.print(request.contextPath)
printHtmlPart(15)
expressionOut.print(request.contextPath)
printHtmlPart(16)
expressionOut.print(request.contextPath)
printHtmlPart(17)
expressionOut.print(request.contextPath)
printHtmlPart(18)
expressionOut.print(request.contextPath)
printHtmlPart(19)
expressionOut.print(request.contextPath)
printHtmlPart(20)
expressionOut.print(request.contextPath)
printHtmlPart(21)
expressionOut.print(request.contextPath)
printHtmlPart(22)
expressionOut.print(request.contextPath)
printHtmlPart(23)
expressionOut.print(request.contextPath)
printHtmlPart(24)
expressionOut.print(request.contextPath)
printHtmlPart(25)
expressionOut.print(request.contextPath)
printHtmlPart(26)
expressionOut.print(request.contextPath)
printHtmlPart(27)
expressionOut.print(request.contextPath)
printHtmlPart(28)
invokeTag('captureMeta','sitemesh',74,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-capable"),'content':("yes")],-1)
printHtmlPart(3)
invokeTag('captureMeta','sitemesh',75,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-status-bar-style"),'content':("black")],-1)
printHtmlPart(29)
invokeTag('captureMeta','sitemesh',77,['gsp_sm_xmlClosingForEmptyTag':(""),'name':("apple-mobile-web-app-title"),'content':("Jarvis")],-1)
printHtmlPart(30)
expressionOut.print(request.contextPath)
printHtmlPart(31)
expressionOut.print(request.contextPath)
printHtmlPart(32)
expressionOut.print(request.contextPath)
printHtmlPart(33)
invokeTag('layoutHead','g',85,[:],-1)
printHtmlPart(34)
invokeTag('javascript','g',86,[:],-1)
printHtmlPart(34)
invokeTag('layoutResources','r',87,[:],-1)
printHtmlPart(35)
expressionOut.print(request.contextPath)
printHtmlPart(36)
})
invokeTag('captureHead','sitemesh',95,[:],1)
printHtmlPart(37)
createTagBody(1, {->
printHtmlPart(38)
invokeTag('layoutBody','g',101,[:],-1)
printHtmlPart(38)
invokeTag('layoutResources','r',103,[:],-1)
printHtmlPart(39)
expressionOut.print(request.contextPath)
printHtmlPart(40)
expressionOut.print(request.contextPath)
printHtmlPart(41)
expressionOut.print(request.contextPath)
printHtmlPart(42)
expressionOut.print(request.contextPath)
printHtmlPart(43)
expressionOut.print(request.contextPath)
printHtmlPart(44)
expressionOut.print(request.contextPath)
printHtmlPart(45)
expressionOut.print(request.contextPath)
printHtmlPart(46)
expressionOut.print(request.contextPath)
printHtmlPart(47)
expressionOut.print(request.contextPath)
printHtmlPart(48)
expressionOut.print(request.contextPath)
printHtmlPart(49)
expressionOut.print(request.contextPath)
printHtmlPart(50)
expressionOut.print(request.contextPath)
printHtmlPart(51)
expressionOut.print(request.contextPath)
printHtmlPart(52)
expressionOut.print(request.contextPath)
printHtmlPart(53)
expressionOut.print(request.contextPath)
printHtmlPart(54)
expressionOut.print(request.contextPath)
printHtmlPart(55)
expressionOut.print(request.contextPath)
printHtmlPart(56)
expressionOut.print(request.contextPath)
printHtmlPart(57)
expressionOut.print(request.contextPath)
printHtmlPart(58)
expressionOut.print(request.contextPath)
printHtmlPart(59)
expressionOut.print(request.contextPath)
printHtmlPart(60)
expressionOut.print(request.contextPath)
printHtmlPart(61)
expressionOut.print(request.contextPath)
printHtmlPart(62)
expressionOut.print(request.contextPath)
printHtmlPart(63)
expressionOut.print(request.contextPath)
printHtmlPart(64)
expressionOut.print(request.contextPath)
printHtmlPart(65)
expressionOut.print(request.contextPath)
printHtmlPart(66)
expressionOut.print(request.contextPath)
printHtmlPart(67)
expressionOut.print(request.contextPath)
printHtmlPart(68)
expressionOut.print(request.contextPath)
printHtmlPart(69)
expressionOut.print(request.contextPath)
printHtmlPart(70)
expressionOut.print(request.contextPath)
printHtmlPart(71)
expressionOut.print(request.contextPath)
printHtmlPart(72)
expressionOut.print(request.contextPath)
printHtmlPart(73)
expressionOut.print(request.contextPath)
printHtmlPart(74)
expressionOut.print(request.contextPath)
printHtmlPart(75)
expressionOut.print(request.contextPath)
printHtmlPart(76)
expressionOut.print(request.contextPath)
printHtmlPart(77)
expressionOut.print(request.contextPath)
printHtmlPart(78)
expressionOut.print(request.contextPath)
printHtmlPart(79)
expressionOut.print(request.contextPath)
printHtmlPart(80)
expressionOut.print(request.contextPath)
printHtmlPart(81)
expressionOut.print(request.contextPath)
printHtmlPart(82)
expressionOut.print(request.contextPath)
printHtmlPart(83)
expressionOut.print(request.contextPath)
printHtmlPart(84)
expressionOut.print(request.contextPath)
printHtmlPart(85)
expressionOut.print(request.contextPath)
printHtmlPart(86)
expressionOut.print(request.contextPath)
printHtmlPart(87)
expressionOut.print(request.contextPath)
printHtmlPart(88)
expressionOut.print(request.contextPath)
printHtmlPart(89)
expressionOut.print(request.contextPath)
printHtmlPart(90)
expressionOut.print(request.contextPath)
printHtmlPart(91)
expressionOut.print(request.contextPath)
printHtmlPart(92)
expressionOut.print(request.contextPath)
printHtmlPart(93)
})
invokeTag('captureBody','sitemesh',270,[:],1)
printHtmlPart(94)
}
public static final Map JSP_TAGS = new HashMap()
protected void init() {
	this.jspTags = JSP_TAGS
}
public static final String CONTENT_TYPE = 'text/html;charset=UTF-8'
public static final long LAST_MODIFIED = 1398757020476L
public static final String EXPRESSION_CODEC = 'html'
public static final String STATIC_CODEC = 'none'
public static final String OUT_CODEC = 'html'
public static final String TAGLIB_CODEC = 'none'
}
