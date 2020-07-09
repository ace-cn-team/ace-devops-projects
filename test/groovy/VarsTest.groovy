import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test

/**
 * @author Caspar* @contract 279397942@qq.com
 * @create 2020/7/9 15:56
 * @description
 */
class VarsTest extends BasePipelineTest {
    @Override
    @Before
    void setUp() throws Exception {
        // 告诉框架，共享库脚本所在的目录
        scriptRoots = ["vars"];
        // 初始化框架
        super.setUp();
    }

    @Test
    void call() {
        // 加载脚本
        def script = loadScript("aceProjectConfig.groovy")
        // 运行脚本
        script.call()

        // 框架提供的方法，后面会介绍。
        printCallStack()
    }
}
