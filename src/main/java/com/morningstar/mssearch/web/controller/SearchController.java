package com.morningstar.mssearch.web.controller;

import com.morningstar.mssearch.common.response.Response;
import com.morningstar.mssearch.common.util.JsonParseUtil;
import com.morningstar.mssearch.web.entity.Post;
import com.morningstar.mssearch.web.entity.SearchRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
@RestController
@RequestMapping("search")
public class SearchController {

    private static List<Map<String, Object>> mockdataMap = new ArrayList<>();


    @PostMapping("searchPosts")
    public Response searchPosts(@RequestBody SearchRequest searchRequest) {
        int type = Integer.valueOf(searchRequest.getSourceType());
        if (type == 0) { //All
            List data = new ArrayList<>();
            for (Map<String, Object> objectMap : mockdataMap) {
                Object object = objectMap.get(searchRequest.getKeyWords().toLowerCase());
                if (object != null) {
                    data.addAll((List) object);
                }
            }
            return Response.createBySuccess(data);
        } else {
            Object data = mockdataMap.get(type).get(searchRequest.getKeyWords().toLowerCase());
            if (data != null) {
                return Response.createBySuccess(data);
            }
        }

        return Response.createBySuccess("No data", new ArrayList<>());
    }


    static {

        mockdataMap.add(new HashMap<>());   //All 0
        mockdataMap.add(new HashMap<>());   //Yammer 1
        mockdataMap.add(new HashMap<>());   //Confluence 2
        mockdataMap.add(new HashMap<>());   //Sourcecode 3
        mockdataMap.add(new HashMap<>());   //Jira 4

        // COVID-19
        List<Post> postList1 = (List<Post>) JsonParseUtil.JsonToArrayList(
                "[\n" +
                        "\t    {\n" +
                        "\t\t\t\"title\": \"COVID-19 Town Halls\",\n" +
                        "\t\t\t\"content\": \"We’ll be hosting a 30-minute COVID-19 town hall twice each Tuesday—once at 9-9:30 a.m. CDT and again at 9-9:30 p.m. CDT (GMT-5). During each town hall, you’ll hear from Morningstar leaders regarding business updates, COVID-19 progression, policy changes, and insights around the world. We'll feature different leaders and new content each week. Please prioritize this weekly event, as it’s an integral way to connect with our leadership and stay informed during this unusual period in time.\",\n" +
                        "\t\t\t\"url\": \"https://mswiki.morningstar.com/display/HOME/Our+Latest+Guidance#OurLatestGuidance-COVID-19TownHalls\",\n" +
                        "\t\t\t\"sourceType\":\"pond\",\n" +
                        "\t\t\t\"createTime\": \"10/15/2020\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"title\": \"COVID-19 Information Hub\",\n" +
                        "\t\t\t\"content\": \"Hi everyone,Congratulations again to the third-quarter Global Values Awards Winners (and thank you to everyone who submitted a nomination). The winning colleagues were nominated by their peers for going above and beyond to live Morningstar’s mission and to demonstrate value in their work. I’m so proud to see the collection of good work represented by this cycle’s winners, which includes an “investor’s first” approach to our COVID-19 response, “uncompromising ethics” around the Level 2 Data Team evolution, and more.I want to thank Dan Costello for joining today’s town hall to discuss our continued return to office transition. To recap, on Nov. 1, offices in Sydney, Hong Kong, Tokyo, Seoul, Bangkok, and Oakland, MD will transition to Phase 2 of our return-to-office framework, allowing for higher density and more encouragement to work in the office. In addition, our Delhi and Singapore offices will reopen and begin Phase 1 transition. As noted, we’re also working with each office over the next couple of weeks to enable basic kitchen and beverage services, as well as some conference and collaboration spaces for use during both Phases 1 and 2. Our goal is to make all offices more amenable and comfortable for individual work and occasional group activity.I understand that, as we look to the future, there is continued uncertainty about what the “new normal” holds. During the “Thorny Issues” session at our upcoming Company Meeting, I’ll provide a more comprehensive and long-term look at our back-to-office plan, detailing how Morningstar is thinking about the future of work and the role of the physical office. The Company Meeting, taking place Oct. 27-29, will replace our next COVID-19 Town Hall – so we’ll send our next edition of this email in November. In the meantime, I encourage you to check out a video of my opening remarks at MOATS last week, which will help set the context of our 2020 overview at the Company Meeting.Have a good week everyone,Kunal\",\n" +
                        "\t\t\t\"url\": \"https://mswiki.morningstar.com/display/HOME/Novel+Coronavirus+%28COVID-19%29+Information+Hub\",\n" +
                        "\t\t\t\"sourceType\":\"pond\",\n" +
                        "\t\t\t\"createTime\": \"10/13/2020\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\n" +
                        "\t\t\t\"title\": \"COVID-19 Global Update | Sept. 29\",\n" +
                        "\t\t\t\"content\": \"Hi everyone,There’s no doubt Morningstar colleagues in cities around the world have felt the importance of connecting with our communities in light of challenges the pandemic has introduced or even exacerbated. During this morning’s Town Hall, Joan Schaper — selected earlier this year to galvanize our efforts around COVID-19 community response — provided a look at Morningstar’s global community outreach efforts, showcasing some of the creative and impactful ways our teams on the ground are supporting their cities through fundraising and volunteering. Your office champions have more details on how we’re proceeding locally, and I encourage you to reach out to them if you have an interest in contributing.In the meantime, I believe it’s a priority that all colleagues have the time, resources, and support to take advantage of the opportunity to vote where it exists. While many colleagues around the world vote on weekends or public holidays, for others, voting happens during the workweek. We’re introducing new guidance that gives all global colleagues the flexibility to vote during working hours, without it counting against vacation or annual leave time. If you’d like to take an even more active role in the election process, you can take off one paid day to volunteer either as an Election Day poll worker, or for a nonpartisan organization that encourages voting. Check out the Pond for details.This guidance is inspired in part by our recent partnerships with Time To Vote and the Civic Alliance, two nonpartisan groups that value civilian participation in the democratic process. We’re in good company as part of these alliances, joined by the likes of Capital One, BMO Harris Bank, JP Morgan Chase & Co, and many others. I hope these partnerships, as well as our new voting guidance, inspire your active participation in civic life.This morning we also heard from PitchBook, a team that has been performing exceptionally well and negotiating our current environment successfully. John Gabbert (CEO), Steve Bendt (VP of marketing), Paul Santarelli (VP of sales), and Brett Kaluza (VP of customer success) shared some of the ways they’ve supported investors throughout COVID-19. I encourage you to listen to the recording if you missed it and, as always, read and share the editorial and research content from PitchBook, DBRS Morningstar, and Morningstar at the bottom of this email.Finally, you may have noticed we’ve been making progress on the commitment we made this summer to more broadly approach Diversity, Equity, and Inclusion (DEI), particularly by using our platforms to give voice to this topic. For example, at MIC Digital I discussed DEI as an area that I believe will take on greater significance in our industry because of the events of 2020. We’ve also used our media engagement to put a focus on this topic and the data and research expertise we do have on it. On Friday, we held our fourth Investor’s First event of 2020, where I’ve been engaging with other CEOs to discuss short-, medium-, and long-term DEI initiatives we can pursue as an industry. I look forward to providing more updates around DEI at our Company Meeting next month.Speaking of the Company Meeting, tomorrow is the last day to submit Colleague Showcase and Thorny Issues recommendations. This is our largest global colleague event — don’t miss out on this chance to have your voice heard. Submit your ideas here.Have a good week everyone,Kunal\",\n" +
                        "\t\t\t\"url\": \"https://mswiki.morningstar.com/display/HOME/2020/09/29/COVID-19+Global+Update+%7C+Sept.+29\",\n" +
                        "\t\t\t\"sourceType\":\"pond\",\n" +
                        "\t\t\t\"createTime\": \"09/29/2020\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"title\": \"COVID-19 Global Update | Aug. 18\",\n" +
                        "\t\t\t\"content\": \"Report your COVID-19 pandemic work location for U.S. tax reporting: During the COVID-19 pandemic and consistent with government orders and recommendations, Morningstar’s offices were closed, and employees were asked to work remotely. Since some employee’s remote work location may be in a different tax jurisdiction than their office work location, we need to determine if there are any implications to our corporate tax withholding requirements. For Morningstar to accurately report your wages in 2020, we need to understand your physical work location (city and state) during 2020. All Morningstar US employees, including DBRS and PitchBook employees, should use this link to record all actual work locations and the timeframe during which you worked there between March 16, 2020 and Aug. 31, 2020. Please report this information no later than 5 p.m. CDT on Friday, Sept. 4. You can read the specifics here. Check out our most recent survey results: During the weeks of July 27 and Aug. 3, we asked you to share reasons for not using the office in Phase 1. 30% of respondents said they find no benefit to returning to the office at this time, and another 30% are concerned about their commute. During those weeks, 11% of respondents worked from the office or a combination of their home and the office. Only 46% of our people responded to the survey. Read the full results here. Many of us are facing challenges at home due to schools moving to virtual or hybrid learning models, caring for elderly or other family members, and other unique circumstances. If you would benefit from more flexibility, we can support you with several options: A flexible work schedule, allowing you to structure your full-time work week;Utilizing vacation time or paid time-off in one-hour increments to create a temporary “part-time” schedule, while continuing at full pay; and Unpaid leaves of absence or formal part-time schedules – these are available at a prorated pay, but still qualify you for critical benefits, such as healthcare. If you’re interested in exploring any of these options, please reach out to your Talent & Culture or HR business partner. We’re also very open to hearing any ideas or suggestions that you have – please email AskHR@morningstar.com.\",\n" +
                        "\t\t\t\"url\": \"https://mswiki.morningstar.com/display/HOME/2020/08/18/COVID-19+Global+Update+%7C+Aug.+18\",\n" +
                        "\t\t\t\"sourceType\":\"pond\",\n" +
                        "\t\t\t\"createTime\": \"08/18/2020\"\n" +
                        "\t\t},\n" +
                        "\t\t{\n" +
                        "\t\t\t\"title\": \"COVID-19 Global Update | July 21\",\n" +
                        "\t\t\t\"content\": \"Hi everyone,I want to once again thank Frannie Besztery, Mike Wood, and Michael Sawula for joining today’s COVID-19 town hall to discuss updates to our Diversity, Equity, and Inclusion strategy. DEI is such a personal topic for all of us, and I find it exciting to see the way we’ve merged the human and data-driven elements of our DEI action plan. We’ll continue to keep our DEI Hub updated with progress and next steps.As more offices around the world open for voluntary access, I want to remind everyone of the importance of personal responsibility. Please do the right thing to keep everyone around you safe by following all office protocols and be mindful and respectful of those who are keeping our buildings and facilities safe. Stay home if you feel unwell, have engaged in high-risk activities (such as traveling to COVID-19 hotspots), or believe you may have been exposed to the virus. In these instances, we ask that you do not physically come to the office for at least 14 days.As a reminder, in the event that someone in your office location contracts COVID-19, here is a link to our official protocol on the COVID-19 Hub. To summarize, we notify each individual we believe may have been in close contact with a colleague who has contracted COVID-19 and implement extra sanitization measures to a sick colleague’s workstation and nearby common areas. To help us take action as quickly as possible, we encourage you to immediately communicate if you’ve been diagnosed with, or otherwise believe you may have contracted, COVID-19 by reaching out to the Response Team. It is incredibly important that this information is shared with us, and the information will remain confidential. You can also reach out to the Response Team if you have any questions about COVID-19 guidelines, protocol, or procedures.We will not have a COVID-19 Town Hall next Tuesday, in favor of our second-quarter Earnings Recap Town Hall on Wednesday, July 29. The month of August tends to be a common time for vacations, so we’ll host a COVID-19 Town Hall every other week next month.Finally, please continue to fill out your weekly Workday surveys, which have been incredibly helpful as we continue to navigate office re-openings.Have a great week everyone,Kunal \",\n" +
                        "\t\t\t\"url\": \"https://mswiki.morningstar.com/display/HOME/2020/07/21/COVID-19+Global+Update+%7C+July+21\",\n" +
                        "\t\t\t\"sourceType\":\"pond\",\n" +
                        "\t\t\t\"createTime\": \"07/21/2020\"\n" +
                        "\t\t}\n" +
                        "\t]",
                Post.class);

        mockdataMap.get(2).put("covid-19", postList1);

        // person
        List<Post> postList2 = (List<Post>) JsonParseUtil.JsonToArrayList(
                "[" +
                        "{\n" +
                        "\n" +
                        "\t\t\t\"title\": \"\",\n" +
                        "\t\t\t\"content\": \"Understanding in-person meetings between advisors and clients has been changing and only accelerated by Stay-at-Home orders due to COVID 19, today we engaged a group of advisors through our User Research team and asked a few questions about perspective on their virtual meetings with their clients and prospective clients over the last 9 weeks since the pandemic has occurred. We asked:1.) What they are using 2.) How often using with clients and prospects 3.) Ways they are illustrating decisions and trade-offs with their clients and prospects.  We had done a somewhat similar study back in 2017, so it is going to be very interesting to compare the results. #moretocome \",\n" +
                        "\t\t\t\"url\": \"https://www.yammer.com/morningstar.com/#/Threads/show?threadId=698804746141696\",\n" +
                        "\t\t\t\"sourceType\":\"yammer\",\n" +
                        "\t\t\t\"createTime\": \"05/28/2020\"\n" +
                        "\t\t}" +
                        "]",
                Post.class);

        mockdataMap.get(1).put("person", postList2);
        mockdataMap.get(1).put("covid-19", postList2);
    }
}
