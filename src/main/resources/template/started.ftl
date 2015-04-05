<#include "macro.ftl">
<@header title="Web 开发起步" />
<div class="header">
    <h1>起步</h1>
    <h2>集中说一下 HTML 相关的内容</h2>
</div>
<div class="content">
    <h2>HTML 部分</h2>
    <p class="p">编写 HTML 代码时，应尽量遵循 HTML 标准和语义，但是不要以牺牲实用性为代价。任何时候都要尽量使用最少的标签并保持最小的复杂度。</p>
    <p class="p">为每个 HTML 页面的第一行添加<code>标准模式</code>（standard mode）的声明，这样能够确保在每个浏览器中拥有一致的展现。</p>
    <aside>
        <p>这里着重推荐一下<a href="http://emmet.io/"  target="_blank" title="Emmet 官方主页"><code>Emmet</code></a>，很多人称之为神器。
            若要论其神在何处，还得要看怎么运用。简单来说，它是是一套基于类似 CSS 选择器语法的编码方案，可以大幅提高我们的编码速度。更重要的是，它能够通过短代码来快速生成各种难以记忆的文档模型。比如
            <a href="assets/txt/html.5.txt" target="_blank" title="文档结构"><code>html:5</code></a>用于生成标准的 HTML5 文档结构；
            <a href="assets/txt/html.xt.txt" target="_blank" title="文档结构"><code>html:xt</code></a>则对应的是 HTML4 的过渡型结构……
        </p>
    </aside>
    <p class="p">首先，指定文档的字符编码是必不可少的。</p>
    <pre class="code code-wrap" data-language="html">
        <meta charset="UTF-8">
    </pre>
    <p class="p">天朝之内，兼容 IE 是必须的。过特定的 <meta> 标签来确定绘制当前页面所应该采用的 IE 版本。除非有强烈的特殊需求，否则最好是设置为 <a href="http://stackoverflow.com/questions/6771258/whats-the-difference-if-meta-http-equiv-x-ua-compatible-content-ie-edge-e" target="_blank" title="关于 IE 各版本 model 的细节"><code>edge mode</code></a>，从而通知 IE 采用其所支持的最新的模式。</p>
    <pre class="code code-wrap" data-language="html">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    </pre>
    <p class="p">各种<code>X核</code>也是吾辈无法言喻的痛，<a href="http://m.baidu.com/pub/help.php?pn=22&ssid=0&from=844b&bd_page_type=1" target="_blank" title="SiteApp转码声明">某度的流氓行径</a>更是叹为观止……一切合理与不合理都可以用国情来解释，我们也不得不做一些迎合国情的准备。</p>
    <pre class="code code-wrap" data-language="html">
        <meta name="renderer" content="webkit">
        <meta http-equiv="Cache-Control" content="no-siteapp" />
    </pre>
    <p class="p">以移动优先的理念开发，需要在 <a href="https://www.w3.org/wiki/HTML/Elements/meta" target="_blank" title="HTML/Elements/meta"><code>meta</code></a>中设置相关 <a href="https://developer.mozilla.org/en-US/docs/Mozilla/Mobile/Viewport_meta_tag" target="_blank" title="Using the viewport meta tag to control layout on mobile browsers"><code>viewport</code></a>属性。移动终端的浏览器是把页面放在一个虚拟的“窗口”（viewport）中，某以为好的设计是不需要用户去操作窗口缩放的。因此我习惯在 meta 中声明<code>viewpoint</code>是不需要（禁止）缩放的。</p>
    <pre class="code code-wrap" data-language="html">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    </pre>
    <p class="p">综合上述的关键内容，一份基础的 HTML 文档大概是 <a class="pure-button" href="assets/txt/html5.template.txt" target="_blank" title="戳我查看完整的模版">这个样子</a> 的。</p>
    <h2>CSS 部分</h2>
    <p class="p">建议将 CSS 作为外部资源引入文档，至于为什么我觉得没有必要讨论和解释。<a href="http://www.w3.org/TR/2011/WD-html5-20110525/semantics.html#the-style-element" target="_blank" title="The style element">link 引入 CSS 文件</a>的时一般不需要指定 type 属性，因为<code>text/css</code>是的默认值。</p>
    <pre class="code code-wrap" data-language="html">
        <link rel="stylesheet" href="assets/css/normalize.css">
    </pre>
    <ol>
        <li><a href="https://en.bem.info/method/definitions/" target="_blank" title="What is BEM?">选择器命名</a>遵循关注分离、松耦合的原则，同时注重易于理解、理解，采用更优雅的书写方式；</li>
        <li>选择符嵌套在必要的情况下一般不超过三层，选择符叠加一般不多于两个；</li>
        <li>为选择器分组时，将单独的选择器单独放在一行；</li>
        <li>所有声明语句都应当以分号结尾，尽管最后一条声明语句后面的分号是可选的；</li>
        <li>对于属性值或颜色参数，省略小于 1 的小数前面的 0，例如，<code>.5</code>代替<code>0.5</code>；<code>-.5px</code>代替<code>-0.5px</code>；</li>
        <li>避免为 0 值指定单位，例如，用<code>margin: 0;</code>代替<code>margin: 0px;</code>……</li>
    </ol>
    <pre class="code code-wrap" data-language="css">
        .selector,
        .selector-secondary,
        .selector[type="text"] {
          padding: 15px;
          margin-bottom: 15px;
          background-color: rgba(0,0,0,.5);
          box-shadow: 0 1px 2px #ccc, inset 0 1px 0 #fff;
        }
    </pre>
    <aside>
        <p>对于这里用到的术语有疑问？请参考 Wikipedia 上的 <a href="http://en.wikipedia.org/wiki/Cascading_Style_Sheets#Syntax" target="_blank" title="syntax section of the Cascading Style Sheets article">syntax section of the Cascading Style Sheets article</a>。此外，<code>Emmet</code>也适用于编写 CSS，有兴趣的朋友可以参考其官方文档。</p>
    </aside>
</div>
<@footer />