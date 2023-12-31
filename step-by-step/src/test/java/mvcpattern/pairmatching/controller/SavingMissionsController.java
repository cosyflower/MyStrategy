package mvcpattern.pairmatching.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import mvcpattern.pairmatching.model.Level;
import mvcpattern.pairmatching.repository.MissionRepository;

public class SavingMissionsController extends AbstractController {
    public final MissionRepository missionRepository;

    public SavingMissionsController(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    @Override
    public void doProcess(Map<String, Object> model) {
        saveMissions(getLevelOneMissionNames(), Level.ONE);
        saveMissions(getLevelTwoMissionNames(), Level.TWO);
        saveMissions(getLevelFiveMissionNames(), Level.FIVE);
    }

    private void saveMissions(List<String> missionNames, Level level) {
        missionRepository.saveAllNamesWithLevel(missionNames, level);
    }

    private List<String> getLevelOneMissionNames() {
        return Arrays.asList("성능개선", "배포");
    }

    private List<String> getLevelTwoMissionNames() {
        return Arrays.asList("장바구니", "결제", "지하철노선도");
    }

    private List<String> getLevelFiveMissionNames() {
        return Arrays.asList("자동차경주", "로또", "숫자야구게임");
    }
}
