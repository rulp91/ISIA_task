package test;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;
import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.testkit.engine.EngineTestKit;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({"test"})
class AllTest {

    @Test
    void verifyJupiterContainerStats() {
        EngineTestKit
                .engine("junit-jupiter")
                .selectors(selectClass(MatrizTest.class))
                .execute()
                .containerEvents()
                .assertStatistics(stats -> stats.started(2).succeeded(2));
    }

    @Test
    void verifyJupiterTestStats() {
        EngineTestKit
                .engine("junit-jupiter")
                .selectors(selectClass(MatrizTest.class))
                .execute()
                .testEvents()
                .assertStatistics(stats ->
                        stats.skipped(0).started(7).succeeded(7).aborted(0).failed(0));
    }

}