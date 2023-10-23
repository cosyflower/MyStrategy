package mvcpattern.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mvcpattern.converter.NamesToCrewConverter;
import mvcpattern.model.Course;
import mvcpattern.model.Crew;
import mvcpattern.repository.CrewRepository;

public class ReadingCrewFileController implements Controller {
    public static final String SRC_MAIN_RESOURCES_FRONTEND_MD = "src/main/resources/frontend.md";
    public static final String SRC_MAIN_RESOURCES_BACKEND_MD = "src/main/resources/backend.md";
    // 파일을 읽고
    // database 에 저장해야 한다
    private final CrewRepository crewRepository;

    public ReadingCrewFileController(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public void process(Map<String, Object> model) {
        try {
            List<Crew> backEndCrews =
                    NamesToCrewConverter.convert(readBackEndCrews(), Course.BACKEND);
            crewRepository.saveAll(backEndCrews);

            List<Crew> frontEndCrews =
                    NamesToCrewConverter.convert(readFrontEndCrews(), Course.FRONTEND);
            crewRepository.saveAll(frontEndCrews);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 파일을 읽었습니다");
        }

    }

    private List<String> readFrontEndCrews() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, SRC_MAIN_RESOURCES_FRONTEND_MD);
        return crewNames;
    }

    private List<String> readBackEndCrews() throws IOException {
        List<String> crewNames = new ArrayList<>();
        readFile(crewNames, SRC_MAIN_RESOURCES_BACKEND_MD);
        return crewNames;
    }

    private void readFile(List<String> crewNames, String path) throws IOException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        readLine(crewNames, bufferedReader);
        bufferedReader.close();
    }

    private void readLine(List<String> crewNames, BufferedReader bufferedReader) throws IOException {
        String word = "";
        while ((word = bufferedReader.readLine()) != null) {
            crewNames.add(word);
        }
    }
}
