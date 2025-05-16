@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addRedirectViewController("/", "/main.html"); 변경할지 말지 고민중
    }

}
