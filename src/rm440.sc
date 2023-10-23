;;; Sierra Script 1.0 - (do not remove this comment)
(script# 440)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use n958)
(use StopWalk)
(use Sound)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm440 0
)

(instance rm440 of LLRoom
	(properties
		lookStr {The F.B.I. laboratory is filled with interesting equipment, most of which baffles you.}
		picture 440
		style $000c
		east 450
		west 430
	)
	
	(method (init)
		(proc0_13 450)
		(proc958_0 132 40 442)
		(proc958_0 128 440 432 440 442 444 1430 1440)
		(Load rsSCRIPT 941)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						189
						0
						140
						192
						140
						231
						130
						251
						138
						305
						125
						293
						113
						271
						102
						0
						102
						0
						0
						319
						0
						319
						189
					yourself:
				)
		)
		(gLarry init: normalize: x: 20)
		(if (not (proc0_6 43))
			(Load rsSOUND 443 444 445 446 447 448 449)
			(fartman init: setScript: sMix)
		)
		(proc0_2)
		(self setScript: sRoom)
		(super init:)
		(if (!= gGNumber 430) (gLarry y: 118 view: 570))
		(door init: stopUpd:)
		(computer init: stopUpd:)
		(duck setCycle: Fwd init:)
		(machine init:)
		(contraption init:)
		(books init:)
		(desk init:)
		(southBank init:)
	)
	
	(method (dispose)
		(gLongSong2 fade:)
		(super dispose:)
	)
)

(instance sRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry setMotion: MoveTo 20 (gLarry y?) self)
			)
			(1
				(twit
					init:
					setCycle: StopWalk -1
					setMotion: MoveTo 40 100 self
				)
			)
			(2
				(if (proc0_6 44)
					(proc0_3)
					(self dispose:)
				else
					(proc0_7 44)
					(= seconds 2)
				)
			)
			(3
				(proc0_18 Commander_Twit 440 0 108)
				(= seconds 3)
			)
			(4
				(twit setMotion: MoveTo 133 100 self)
				(gLarry
					cycleSpeed: 6
					moveSpeed: 6
					setMotion: PolyPath 114 105
				)
			)
			(5 (= ticks 60))
			(6
				(twit view: 442 setLoop: 0 setCycle: RandCycle)
				(= ticks 60)
			)
			(7
				(soundFX number: 442 loop: -1 flags: 0 play:)
				(computer startUpd: setCycle: RandCycle)
				(= seconds 4)
			)
			(8
				(proc0_18 Commander_Twit 440 1 108 139 self)
			)
			(9 (= seconds 4))
			(10
				(proc0_10 1)
				(proc0_18 Commander_Twit 440 2 108)
				(= seconds 3)
			)
			(11
				(proc0_18 Commander_Twit 440 3 108)
				(= seconds 2)
			)
			(12
				(proc0_18 Commander_Twit 440 4 108)
				(= seconds 3)
			)
			(13
				(proc0_18 Commander_Twit 440 5 108)
				(= seconds 2)
			)
			(14
				(proc0_18 Commander_Twit 440 6 108)
				(= seconds 2)
			)
			(15
				(proc0_18 Commander_Twit 440 7 108)
				(= seconds 2)
			)
			(16
				(proc0_18 gLarry 440 8 67 -1 185)
				(= ticks 90)
			)
			(17
				(proc0_18 Commander_Twit 440 9 108)
				(= seconds 3)
			)
			(18
				(proc0_18 Commander_Twit 440 10 108 139 self)
			)
			(19
				(soundFX loop: 1 flags: 1 stop:)
				(computer setCycle: 0 stopUpd:)
				(twit
					view: 432
					setCycle: StopWalk -1
					setHeading: 180 self
				)
			)
			(20
				(proc0_18 Commander_Twit 440 11 108)
				(proc0_13 0)
				(gLarry
					moveSpeed: (gGame egoMoveSpeed?)
					cycleSpeed: (gGame egoMoveSpeed?)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sToDoc of Script
	(properties)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				state
				(not register)
				(< (gLarry x?) 231)
				(< (gLarry x?) (- (twit x?) 10))
			)
			(= register 1)
			(gLarry
				cycleSpeed: 6
				moveSpeed: 6
				setMotion: PolyPath 231 108
			)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_18 Commander_Twit 440 12 108 139 self)
			)
			(1
				(twit
					setLoop: -1
					setCycle: StopWalk -1
					setMotion: MoveTo 260 100 self
				)
			)
			(2
				(door setCycle: End self)
				(soundFX number: 40 setLoop: 1 play:)
			)
			(3
				(twit setCycle: 0)
				(proc0_18 Commander_Twit 440 13 108 139 self)
			)
			(4
				(proc0_18 Dr__Phil_Hopian 440 14 108 139 self)
			)
			(5
				(gLarry setMotion: MoveTo 286 106 self)
			)
			(6
				(proc0_18 gLarry 440 15 67 -1 185)
				(= cycles 10)
			)
			(7
				(gLarry setMotion: MoveTo 330 (gLarry y?) self)
			)
			(8
				(proc0_18 Dr__Phil_Hopian 440 16 108 139 self)
			)
			(9 (= seconds 3))
			(10
				(proc0_18 Dr__Phil_Hopian 440 17 108 139 self)
			)
			(11
				(door setCycle: Beg self)
				(soundFX number: 41 setLoop: 1 play:)
			)
			(12
				(proc0_14 440 18)
				(proc0_14 440 19)
				(gLongSong2 fade:)
				(global2 newRoom: 450)
			)
		)
	)
)

(instance sFart of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 43)
				(proc0_18 Commander_Twit 440 20 108 139 self)
			)
			(1
				(proc0_11 gLarry fartman)
				(= seconds 2)
			)
			(2
				(proc0_18 Commander_Twit 440 21 108 139 self)
			)
			(3 (= seconds 3))
			(4
				(fartman setScript: 0 setCycle: End self)
			)
			(5
				(fartman
					setLoop: 1
					setCel: 0
					cycleSpeed: 24
					setCycle: End self
				)
			)
			(6 (= seconds 3))
			(7
				(soundFX number: 444 setLoop: 1 play:)
				(fartman setLoop: 2 setCel: 0 setCycle: End self)
			)
			(8 (= seconds 3))
			(9
				(soundFX number: 445 play:)
				(fartman setLoop: 3 setCel: 0 setCycle: CT 2 1 self)
			)
			(10 (= seconds 2))
			(11
				(fartman
					setCycle: End
					setPri: 11
					setMotion: MoveTo 235 32 self
				)
				(soundFX number: 446 play:)
			)
			(12
				(soundFX number: 447 play:)
				(fartman setCel: 8 setMotion: MoveTo 293 71 self)
			)
			(13
				(soundFX number: 448 play:)
				(fartman setCel: 8 setMotion: MoveTo 252 135 self)
			)
			(14
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 159 14 self)
			)
			(15
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 112 149 self)
			)
			(16
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 114 17 self)
			)
			(17
				(soundFX number: 447 play:)
				(fartman setMotion: MoveTo 169 138 self)
			)
			(18
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 240 11 self)
			)
			(19
				(soundFX number: 449 play:)
				(fartman setMotion: MoveTo 288 68 self)
			)
			(20
				(soundFX number: 448 play:)
				(fartman setMotion: MoveTo 252 135 self)
			)
			(21
				(soundFX number: 443 setLoop: -1 play:)
				(fartman
					setCel: 8
					setLoop: 4
					setMotion: MoveTo 183 76 self
				)
			)
			(22
				(fartman
					setLoop: 5
					setCycle: Fwd
					setStep: 12 2
					cycleSpeed: 6
					setMotion: MoveTo -50 (fartman y?) self
				)
			)
			(23
				(fartman dispose:)
				(soundFX fade:)
				(= seconds 3)
			)
			(24
				(proc0_18 Commander_Twit 440 22 108 139 self)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance twit of Actor
	(properties
		x -15
		y 100
		description {Commander Twit}
		lookStr {He's the perfect image of a man more interested in science than in his own self-image!}
		view 432
		cel 2
		signal $4000
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (self mover?))
				(not (global2 script?))
				(< x 133)
				(> (- (gLarry x?) (self x?)) 20)
			)
			(self setMotion: MoveTo (proc999_2 133 (+ x 10)) y)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 23))
			(5
				(if (not (proc0_6 43))
					(proc0_2)
					(global2 setScript: sFart)
				else
					(proc0_18 Commander_Twit 440 24 108)
				)
			)
			(10 (proc0_14 440 25))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 282
		y 99
		description {Doctor Hopian's door}
		lookStr {Through this door lies the offices of Dr. Phil Hopian, F.B.I. gynecologist.}
		view 440
		loop 1
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sToDoc)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance computer of Prop
	(properties
		x 133
		y 61
		description {the computer}
		sightAngle 40
		lookStr {If only you had paid attention when Larry chattered on and on about his computer. You know nothing about this computer and are sure you'll be unable to do anything with it.}
		view 440
		loop 2
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 26))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fartman of Actor
	(properties
		x 173
		y 157
		yStep 12
		view 444
		signal $6000
		cycleSpeed 24
		illegalBits $0000
		xStep 12
	)
	
	(method (doVerb)
		(proc0_10 3 101)
		(proc0_2)
		(global2 setScript: sFart)
	)
)

(instance sMix of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: CT 1 1 self)
			)
			(1 (= seconds (Random 2 4)))
			(2 (client setCycle: End self))
			(3 (self init:))
		)
	)
)

(instance duck of Prop
	(properties
		x 45
		y 167
		z 7
		description {the duck}
		sightAngle 40
		lookStr {If it drinks like a duck, and it quacks like a duck, it must be an experiment.}
		view 440
		loop 3
		priority 15
		signal $4010
		detailLevel 3
	)
)

(instance Commander_Twit of Talker
	(properties
		nsTop 15
		nsLeft 40
		view 1430
		loop 3
		viewInPrint 1
		name "Commander Twit"
	)
	
	(method (init)
		(= bust twitBust)
		(= eyes twitEyes)
		(= mouth twitMouth)
		(super init: &rest)
	)
)

(instance twitBust of Prop
	(properties
		view 1430
		loop 1
	)
)

(instance twitEyes of Prop
	(properties
		view 1430
		loop 2
		cycleSpeed 30
	)
)

(instance twitMouth of Prop
	(properties
		nsTop 47
		nsLeft 11
		view 1430
		cycleSpeed 8
	)
)

(instance Dr__Phil_Hopian of Talker
	(properties
		nsTop 15
		nsLeft 50
		view 1440
		loop 3
		viewInPrint 1
		name "Dr. Phil Hopian"
	)
	
	(method (init)
		(= bust peltBust)
		(= eyes peltEyes)
		(= mouth peltMouth)
		(super init: &rest)
	)
)

(instance peltBust of Prop
	(properties
		view 1440
		loop 1
	)
)

(instance peltEyes of Prop
	(properties
		nsTop 18
		nsLeft 13
		view 1440
		loop 2
		cycleSpeed 30
	)
)

(instance peltMouth of Prop
	(properties
		nsTop 21
		nsLeft 14
		view 1440
		cycleSpeed 8
	)
)

(instance machine of Feature
	(properties
		x 215
		y 47
		nsTop -1
		nsLeft 170
		nsBottom 95
		nsRight 261
		description {the machine}
		sightAngle 40
		lookStr {This machine does something, you feel quite certain.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 27))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance contraption of Feature
	(properties
		x 114
		y 160
		z 34
		nsTop 115
		nsLeft 94
		nsBottom 137
		nsRight 134
		description {the chemistry set}
		sightAngle 40
		lookStr {This must be the source of the flatulence powder.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 28))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 166
		nsTop 144
		nsBottom 189
		nsRight 319
		description {the workbench}
		sightAngle 40
		lookStr {Lots of chemicals, beakers, and junk food wrappers fill this workbench.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 29))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 41
		y 88
		z 30
		nsTop 49
		nsLeft 28
		nsBottom 68
		nsRight 55
		description {the books}
		sightAngle 40
		lookStr {These books are filled with Latin phrases. The only Latin phrases you know would get a sailor thrown out of a bar in Tijuana!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 30))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 81
		y 87
		z 17
		nsTop 54
		nsBottom 88
		nsRight 162
		description {the desk}
		sightAngle 40
		lookStr {This desk doesn't contain any secret documents; they all were burned in the big fire last week!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 440 31))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)
