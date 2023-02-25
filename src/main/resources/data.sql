@Component
public class TestDataSeeder {

    private final DesignRepository designRepository;

    @Autowired
    public TestDataSeeder(DesignRepository designRepository) {
        this.designRepository = designRepository;
    }

    @PostConstruct
    public void seedData() {
        List<DesignModel> designs = new ArrayList<>();

        // create some test data
        DesignModel design1 = new DesignModel();
        design1.setName("Design 1");
        design1.setDescription("This is the first design.");
        design1.setIsApproved(false);
        designs.add(design1);

        DesignModel design2 = new DesignModel();
        design2.setName("Design 2");
        design2.setDescription("This is the second design.");
        design2.setIsApproved(false);
        designs.add(design2);

        // save the test data to the database
        designRepository.saveAll(designs);
    }
}
