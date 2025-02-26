public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_sports:
                        selectedFragment = new SportsFragment();
                        break;
                    case R.id.nav_tech:
                        selectedFragment = new TechFragment();
                        break;
                    case R.id.nav_entertainment:
                        selectedFragment = new EntertainmentFragment();
                        break;
                    case R.id.nav_politics:
                        selectedFragment = new PoliticsFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit();

                return true;
            }
        });

        // Set default fragment
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.nav_sports); // Set initial fragment
        }
    }
}