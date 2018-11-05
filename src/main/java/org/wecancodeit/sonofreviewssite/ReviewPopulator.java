package org.wecancodeit.sonofreviewssite;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.wecancodeit.sonofreviewssite.model.Category;
import org.wecancodeit.sonofreviewssite.model.Review;
import org.wecancodeit.sonofreviewssite.model.Tag;
import org.wecancodeit.sonofreviewssite.repository.AccountRepository;
import org.wecancodeit.sonofreviewssite.repository.CategoryRepository;
import org.wecancodeit.sonofreviewssite.repository.CommentRepository;
import org.wecancodeit.sonofreviewssite.repository.ReviewRepository;
import org.wecancodeit.sonofreviewssite.repository.TagRepository;

@Service
public class ReviewPopulator implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	ReviewRepository reviewRepo;

	@Resource
	AccountRepository accountRepo;

	@Resource
	CommentRepository commentRepo;

	@Resource
	TagRepository tagRepo;

	@Override

	public void run(String... args) throws Exception {
		Category category1 = new Category("Sweaters");
		Category category2 = new Category("Life Choices");
		Category category3 = new Category("Kids: Which is Best");
		Category category4 = new Category("Hobbies");
		Category category5 = new Category("Worst Dad Jokes");

		category1 = categoryRepo.save(category1);
		category2 = categoryRepo.save(category2);
		category3 = categoryRepo.save(category3);
		category4 = categoryRepo.save(category4);
		category5 = categoryRepo.save(category5);

		// kids
		Review reviewKid1 = new Review("Lizzy",
				"I was there the day Lizzy was born. And from the moment I saw her I knew; she was going to be terrible. When I first held her, she glared at me. I have never forgiven her. She's the most serious person. She has always been good at everything she's done. Sports: Amazing. Studies: Wonderful. Friends: She has too many. I think she thinks she's better than me. Which she's not!",
				"Recommendation: BREAK HER SPIRIT. She must know she is not special.", "3/10", "lizzy.jpg", category3);
		Review reviewKid2 = new Review("Ashley",
				"Such a special child. By far the best kid. Even now in middle school, she's still awesome. I have spent many hours talking to her over thursday dinners. She doesn't seem to get along well with Lizzy, but I know that's Lizzy's fault. ",
				"Recommendation: Give her more attention Greg!", "10/5", "ashley.jpg", category3);
		Review reviewKid3 = new Review("Corbin",
				"Corbin. I mean he's a still a toddler. He seems like a pretty cool little kid I guess. He's super into Spiderman. The most interesting thing about Corbin is the age gap between him and his sisters. Was Corbin a mistake? An unplanned pregnancy? What are you hiding Greg???",
				"Recommendation: Tell me the truth GREG!", "Pending", "corbin.jpg", category3);

		reviewKid1 = reviewRepo.save(reviewKid1);
		reviewKid2 = reviewRepo.save(reviewKid2);
		reviewKid3 = reviewRepo.save(reviewKid3);
		// sweaters
		Review sweater1 = new Review("Greg's Christmas Sweater",

				"Never have I been so gifted, as to see Greg's Chrsitmas Sweater. It was the greatest gift one could recieve. I believe his Great Aunt Mable knitted it for him some years back. It is covered in the finest layer of cat hair, from said Great Aunt Mable. He begins wearing this sweater sometime in mid November and does not take it off till the new year. I dare say he bathes in it. Of all his sweaters this is one of my favorites.",
				"Recommendation: Keep it", "8.7/10", "christmas.jpg", category1);
		Review sweater2 = new Review("Greg's College Sweater",
				"This sweater eminates a kind of naive, hapless earnestness. It doesn't seem to notice how tight it's become, to its benefit. Greg bought this his sophomore year after he finished his cynical phase, and almost lost it in the lake during one of our late-night escapades. The way it smelled for the next week, I wish he had.",
				"Recommendation: Keep it", "8.7/10", "football.jpg", category1);
		Review sweater3 = new Review("Greg's Halloween Sweater",
				"Greg has made a lot of bad decisions in his life. There was the time share in Nepal, there was the vacation to Indianapolis, but his Halloween Sweater makes it into the cannon of great disasters. It is neither spooky, nor cute. I've never felt the hint of a shiver run down my spine. I've never felt warm, fuzzy, harvest-time feelings either. What purpose does this sweater serve? What is its target audience? I don't think anyone knows.",
				"Recommendation: Keep it", "4/10", "halloween.jpg", category1);
		Review sweater4 = new Review("Greg's Inappropriately Small Sweater",
				"Why would you give such an ill-fitting sweater such a high score? I went back and forth on this, but I decided in the end that while it gains no points for fashion, taste, respectability, sense, or general ability of anyone accompanying Greg to maintain their composure, it has its own appeal. When Greg was in high school, he spent a summer abroad in Bratislava, and his little sister decided it might get cold there, so she bought him a wool sweater. As soon as Greg arrived in Czechoslovakia he washed and dried his sweater and shrunk it down to dog size. He felt so bad about it that he continued wearing it anyway, and has since.",
				"Recommendation: Keep it", "10/10", "small.jpg", category1);
		Review sweater5 = new Review("Greg's Kind of Classy Sweater",
				"rThis one is an honest argyle Greg found for 10% off at JC Penny back in 1999. He didn't belive in Y2K and wore this sweater to our New Years party that year, but that history came out in the next wash and it remains an unassuming argyle sweater. It blends in at business meetings better than a bic ballpoint.",
				"Recommendation: Keep it", "6.5/10", "fancy2.jpg", category1);

		sweater1 = reviewRepo.save(sweater1);
		sweater2 = reviewRepo.save(sweater2);
		sweater3 = reviewRepo.save(sweater3);
		sweater4 = reviewRepo.save(sweater4);
		sweater5 = reviewRepo.save(sweater5);

		// hobbies
		Review hobby1 = new Review("Wood Working",
				"Greg was channel-surfing one day in the fall of 2010 and happened upon a show called 'Rough Cut Woodworking with Tommy Mac' and decided that woodworking was his passion. He went out to the neighborhood hardware depot and got himself all the tools of the trade. At one point, he asked me what I thought of a particular lathe and I told him that until today I had never heard of a lathe, and that he should just go with his gut. Long story same length, he scowled at me and purchased a different lathe. Greg spent the rest of the weekend building what can only be described as the world's biggest birdhouse for the world's smallest bird. If I'm being honest, it was a very good first attempt. I've never seen him so proud of any singular achievement. After that, I think he's only really ever made like 3 more things--an oversized wooden spoon, a featureless, human-shaped doll, and a single bedpost.",
				"Recommendation: Get back into it. I think you show some real potential. You just need practice",
				"7/10", "wood.jpg", category4);
		Review hobby2 = new Review("Upholstery",
				"I hesitate to review this here because 1. I don't know if Greg would consider it a hobby so much as a chore and 2. It sort of grew out of his foray into woodworking. Let me explain. Greg found this chair at a garage sale. It was a beautiful, old chair that had clearly seen better days. He wasn't going to buy it, but, despite my MULTIPLE warnings, he sat in it and all of a sudden everyone within a 3 mile radius heard a crack and Greg was on the ground checking himself for a concussion. He graciously handed the previous owners a generous wad of cash and strapped the chair to the roof of his midsized sedan with some twine. The chair lived in his basement until one day Greg decided to \"just fix the damn thing\". He reattached the leg, sanded down some rough spots, patched up some nicks, and got the thing looking pretty good. The only thing left to do was to replace the god-awful upholstery.  Greg checked out a book from a library and spent an afternoon in a Jo-Ann Fabrics before locking himself in his basement. when he emerged he had a fully-functional, absolutely gorgeous, and shockingly comfy chair. Even Carol was impressed. Now, whenever something happens to their furniture (or Carol decides she wants to shake up the feng shui again), Greg takes care of it. And we are all better for it, no matter how much he grumbles about it.",
				"Recommendation: I would sit in any of these chairs with zero arm twisting", "10/10", "upholstery.jpg",
				category4);
		Review hobby3 = new Review("Collecting Shot Glasses",
				"Greg has a simply massive shot glass collection. Yes, I know Mr. \"Oh no a second beer will put me right to sleep\" Greg has somewhere in the area of 1000 shot glasses from all over the world. Yes, I know! Mr. \"Do you think this bar has iced tea\" Greg has more shot glasses than your average bar supplies depot. The whole thing started as a bit of a joke. Most people know that Greg doesn't drink a whole lot, but not a lot of people know why. On Greg's 21st birthday, we threw him a huge party. He was absolutely stoked to finally \"go into the future\" as he called it. Unfortunately, it was not to be. Some of Greg's friends (I'm looking at you Bill (and also you, me)) got a little too enthusiastic, so sweet little Greg had to play babysitter. And janitor. And law enforcement liason. Ever since then, Greg has been less than enthusiastic about alcohol consumption, so much so that a lot of people we know are SHOCKED when Greg does order alcohol. As a result (Greg's general obliviousness are also a very large player in this), there was a period of time where Greg thought that the shot glasses he would find in gift-shops were just tiny commemorative glasses. Greg had done some travelling for work and always came back with one from wherever he went. Then I was getting ready to go on a vacation and I asked Greg if he wanted me to bring him a souvenir. He asked me to bring back \"one of those little baby beer glasses\". I laughed and laughed and laughed and finally clued him in to what he's been buying this whole time. He was a little embarassed, but, in typical Greg fashion dealt with embarassment by leaning into it hard. He will buy any shot glass he finds. I'm pretty sure he's even padded his collection with some just plain shot glasses he got at the liquor store. And now here we are. About 7000 off of the world record, but still nothing to shake a stick at.",
				"Recommendation: You're an idiot and I treasure you", "8/10", "shots.jpg", category4);

		hobby1 = reviewRepo.save(hobby1);
		hobby2 = reviewRepo.save(hobby2);
		hobby3 = reviewRepo.save(hobby3);

		// life choices
		Review lifeChoice1 = new Review("Having Children",
				"When Greg proposed to Carol, he promised he wouldn't become that lame friend who is too busy with his kids to hang out. But he was already a my lame friend- I guess there wasn't any further down to go, so I can't hold this life decision against him. On the whole, I think he's learned a bit about responsibility, but forgotten lots more about music not sung by a choir of six year olds, which I would consider a loss. But Greg has never had cool points to loose, so perhaps it's been a net gain. If it weren't for Lizzy I think this would have been an alright descision.",
				"Recommendation: Know when to stop.", "6/10", "having-children.jpg", category2);
		Review lifeChoice2 = new Review("Jobs",
				"Greg used to have the best jobs. His first job was working at the local ice cream show. I must have gained five pounds in that time. Then, he worked as a chef in college. He would always give me free meals there too. But now, he's a middle school teacher. And all of my free stuff has gone away. Where's my ice cream Greg? Where is my free stuff? Sure he tutor's my kid in English, but still.",
				"Recommendation: Get a job that gets me more free stuff.", "7.5/10", "ice-cream-job.jpg", category2);
		// house
		Review lifeChoice3 = new Review("House",
				"I have to say. Greg's house is pretty cool. The whole place is overlly cute. There is plush pillows and soft blankets as far as the eye can see. Carol and Greg have really blended their two styles together. I will say Carol seems to have a better eye for design than Greg does. The house itself has lots of natural light and funky built ins. They even have original hard woods. The backyard is the perfect size and they even have a tree house. ",
				"Recommendation: Let Carol Go wild", "9/10", "house.jpg", category2);

		// degree english
		Review lifeChoice4 = new Review("Degree: English",
				"You fool, Greg. You FOOL! You could have been anything you wanted to be. You were so smart. And yet you decided to major in English? Yes I know you love reading. I've spent so many summers reading with you. But you nerd! Yes I know you're writting a novel. And yes I am so proud of you for publishing that short story. But come on dude. And YES I know you love being a teacher. And it gives you a purpose and all. But come on man, English?",
				"Recommendation: You should have listened to your dad.", "2/10", "degree.jpg", category2);

		lifeChoice1 = reviewRepo.save(lifeChoice1);
		lifeChoice2 = reviewRepo.save(lifeChoice2);
		lifeChoice3 = reviewRepo.save(lifeChoice3);
		lifeChoice4 = reviewRepo.save(lifeChoice4);

		// dad jokes
		Review dadJoke1 = new Review("Joke about a pepper.",
				"Here is, verbatim, a joke Greg told me once: \"There's this one, that's... How do you... Wait, how. I'm trying to think how this one goes. There's a peppper... Oh! How do you know know if a pepper is nosey? (Greg paused here)... He gets jalapeno business!\" There's an art to delivery in comedy. And then there's the art of delivering a joke so poorly that the delivery is the joke. This skill cannot be mastered, but some master it anyway.",
				"Recommendation: Needs some work. Would be greatly depricated by being worked on.", "6/10",
				"bad-pepper-joke.jpg", category5);
		dadJoke1 = reviewRepo.save(dadJoke1);

		Review dadJoke2 = new Review("A surprisingly honest aphorism",
				"I don't remember what the prank was, but it was April 1st, 2003. Not to toot my own horn, but it was a pretty good prank, and I played Greg like a silk fiddle. After realizing he'd been fooled, Greg looked me dead in the eyes and said \"fool me once, shame on me. But teach a man to fool me, and I'll be fooled for the rest of my life.\"",
				"Recommendation: Engrave this on a statue of Greg.", "20/10", "honest-aphorism.jpg", category5);
		dadJoke2 = reviewRepo.save(dadJoke2);

		Review dadJoke3 = new Review("Joke about an overweight gourd",
				"I've reviewed Greg's halloween sweater, and you can find my [poor] opinion of that documented elsewhere. But it bears mentioning as the catalyst for one of Greg's earliest dad jokes. In December 1998 my cousin was repairing his water main and doing about as well as a drunk sea lion with a ratchet set, and Greg started running out of clean laundry. He had to resort to his terrible Halloween sweater, and after the thanksgiving feast at his parents' house, is was fairly snug. As he was shimmying it over his belly he asked me what I would call an overweight pumpkin. \"What?\", I asked. \"A plumpkin!\", he said, delighted.",
				"Recommendation; Don't quit your day job", "4/10", "plumpkin.jpg", category5);
		dadJoke3 = reviewRepo.save(dadJoke3);

		Review dadJoke4 = new Review("Joke at the supermarket",
				"The second time Greg ever used the blender he bought Carol was when we decided to make milkshakes around midnight one tuesday. We'd already portioned the ice cream into the blender when we realized Greg was out of milk, and had to run to the store before it melted. We grabbed some 2% and as we were checking out, the cashier asked us if we wanted the single carton of milk in a bag. Not missing a beat, Greg said, \"no, you can leave it in the carton.\"",
				"Recomendation: She was just trying to do her job, Greg.", "8/10 for quick thinking", "milk-bag.jpg",
				category5);
		dadJoke4 = reviewRepo.save(dadJoke4);

		// COMMENTS-------------------
//		Account jerkGuy = new Account("MAGA420blazin69");
//		Comment jerkComment1 = new Comment(jerkGuy, "these sewaters are laaaaaaaame", dadJoke4);
//		Comment jerkComment2 = new Comment(jerkGuy, "also that s anot a good joeke", dadJoke4);
//		jerkGuy = accountRepo.save(jerkGuy);
//		jerkComment1 = commentRepo.save(jerkComment1);
//		jerkComment2 = commentRepo.save(jerkComment2);

		// TAGS-------------------------------------------------
		Tag brain = new Tag("Greg's Brain Doesn't Work");
		brain = tagRepo.save(brain);
		Tag veggies = new Tag("Vegetables");
		veggies = tagRepo.save(veggies);
		dadJoke1.addTag(veggies); // joke about a pepper
		dadJoke1.addTag(brain); // joke about a pepper
		dadJoke2.addTag(brain); // honest aphorism
		brain.addReview(dadJoke1);
		veggies.addReview(dadJoke1);
		brain.addReview(dadJoke2);
		dadJoke1 = reviewRepo.save(dadJoke1);
		dadJoke2 = reviewRepo.save(dadJoke2);
		veggies = tagRepo.save(veggies);
		brain = tagRepo.save(brain);

	}

}
